package com.alibaba.otter.canal.parse.driver.mysql;

import com.alibaba.otter.canal.parse.driver.mysql.packets.server.ResultSetPacket;
import com.alibaba.otter.canal.parse.driver.mysql.ssl.SslInfo;
import com.alibaba.otter.canal.parse.driver.mysql.ssl.SslMode;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

class MysqlConnectorTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final String hostname = "127.0.0.1";
    private final int port = 3306;
    private final String username = "root";
    private final String password = "changeme";

    @Test
    void testQueryCharset() throws IOException {
        MysqlConnector connector = new MysqlConnector(
                new InetSocketAddress(hostname, port),
                username, password);
        try {
            connector.connect();
            MysqlQueryExecutor executor = new MysqlQueryExecutor(connector);
            ResultSetPacket result = executor.query("show variables like 'character_set_server';");
            logger.info("{}", result);
        } finally {
            connector.disconnect();
        }
    }

    @Test
    void testQueryCharsetSsl() throws IOException {
        SslInfo sslInfo = new SslInfo();
        sslInfo.setSslMode(SslMode.REQUIRED);
        MysqlConnector connector = new MysqlConnector(
                new InetSocketAddress(hostname, port),
                username, password,
                null,
                sslInfo);
        try {
            connector.connect();
            MysqlQueryExecutor executor = new MysqlQueryExecutor(connector);
            ResultSetPacket result = executor.query("show variables like '%char%';");
            logger.info("{}", result);
        } finally {
            connector.disconnect();
        }
    }
}