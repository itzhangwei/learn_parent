package com.learn.dump;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title DumpInStart
 * @package com.learn.dump
 * @description springboot启动前做的事
 * @date 2018/12/26 13:35
 */
@Component
@Order(value = 1)
public class DumpInStart implements CommandLineRunner {
    /**日志*/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DruidDataSource dataSource;
    private  String fileName;


    @Autowired
    public DumpInStart(DataSource dataSource) {
        //配置的是 DruidDataSource 所以在这里装换下，如果直注入 DruidDataSource 程序也是不会报错
        // 只是 idea 的代码检查会发现不到这个类型的datasource
        this.dataSource = (DruidDataSource) dataSource;

        //获取当前项目路径
        fileName = System.getProperty("user.dir")+"\\learn_support_db\\src\\main\\resources\\backup\\db_backUp.sql";

    }

    /**
     * com.learn.dump.DumpInStart.run
     * @param args 运行参数
     * @description springboot启动时候备份一份数据备份文件到本地 <BR>
     * @author 张伟
     * @createTime 2018/12/26 18:20
     * @version V1.0.0
     */
    @Override
    public void run(String... args) {
        try {
            logger.info("**************程序启动前先dump我们的数据库**************");
            String username = dataSource.getUsername();
            String password = dataSource.getPassword();
            String url = dataSource.getUrl();

            String dbType = dataSource.getDbType();
            String dbName = "";
            String host = "";
            String port = "";
            if ("mysql".equalsIgnoreCase(dbType)) {
                String substring = url.substring(url.indexOf(dbType)+dbType.length() + 3);
                host = substring.substring(0, substring.indexOf(":"));
                port = substring.substring(substring.indexOf(":")+1, substring.indexOf("/"));
                dbName = substring.substring(substring.indexOf("/")+1, substring.indexOf("?"));
            }

            if (this.isWin()) {
                String dumpSql = new StringBuffer().append("cmd /c mysqldump")
                        .append(" -h").append(host)
                        .append(" -P").append(port)
                        .append(" -u").append(username)
                        .append(" -p").append(password)
                        .append("  ").append(dbName)
                        .append(" > ")
                        .append(this.fileName).toString();
                //String dumpSql = "cmd /c mysqldump -hlocalhost:3306  -uroot -pzhangwei  jeeplateform > d://jeeplateform-db.sql";
                //dataSource.getConnection().prepareStatement(dumpSql);
                Process exec = Runtime.getRuntime().exec(dumpSql);
                logger.info("******************备份数据库成功****************");
            }
        } catch (IOException e) {
            logger.info("******************备份数据库失败****************");
        }

    }

    /**
     * com.learn.dump.DumpInStart.isWin
     * @description 判断操作系统是不是windows <BR>
     * @return boolean
     * @author 张伟
     * @createTime 2018/12/26 18:17
     * @version V1.0.0
     */
    private boolean isWin() {
        return System.getProperties().getProperty("os.name").toLowerCase().contains("win");
    }
}
