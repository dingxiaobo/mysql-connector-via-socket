package com.alibaba.otter.canal.parse.driver.mysql.packets;

public abstract class PacketWithHeaderPacket implements IPacket {

    protected HeaderPacket header;

    protected PacketWithHeaderPacket() {
    }

    protected PacketWithHeaderPacket(HeaderPacket header) {
        setHeader(header);
    }

    public void setHeader(HeaderPacket header) {
        if (header == null) {
            throw new IllegalArgumentException("header can't null");
        }
        this.header = header;
    }

    public HeaderPacket getHeader() {
        return header;
    }

}
