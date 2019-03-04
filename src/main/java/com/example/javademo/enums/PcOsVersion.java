package com.example.javademo.enums;

/**
 * 创建枚举类型，
 */
public enum PcOsVersion {
    //每一个枚举就是一个实例，其中三个参数是他的有参构造，返回的是一个实例
    WIN_10("Windows 10", "10.0.1", "10"),
    WIN_SERVER_2016("Windows Server 2016", "10.0.0", "10"),
    WIN_8_1("Windows 8.1", "6.3.1", "8"),
    WIN_SERVER_2012_R2("Windows Server 2012 R2", "6.3.0", "8"),
    WIN_8("Windows 8", "6.2.1", "8"),
    WIN_SERVER_2012("Windows Server 2012", "6.2.0", "8"),
    WIN_7("Windows 7", "6.1.1", "7"),
    WIN_SERVER_2008_R2("Windows Server 2008 R2", "6.1.0", "7"),
    WIN_SERVER_2008("Windows Server 2008", "6.0.0", "vista"),
    WIN_VISTA_6_0("Windows Vista 6.0", "6.0.1", "vista"),
    WIN_SERVER_2003("Windows Server 2003", "5.2.0", "xp"),
    WIN_XP("Windows XP", "5.1.0", "xp"),
    WIN_XP_1("Windows XP", "5.1.1", "xp");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsSerial() {
        return osSerial;
    }

    public void setOsSerial(String osSerial) {
        this.osSerial = osSerial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String name;
    private String osSerial;
    private String type;

    //给出有参构造，第一是名字，第二个系统编号，第三个是版本
    PcOsVersion(String name, String osSerial, String type) {
        this.name = name;
        this.osSerial = osSerial;
        this.type = type;
    }

    /**
     * 根据操作系统版本号得出操作系统名称
     *
     * @param osSerial
     * @return
     */
    public static String getOsVersion(String osSerial) {
        for (PcOsVersion e : PcOsVersion.values()) {
            if (e.getOsSerial().equals(osSerial)) {
                return e.getName();
            }
        }
        return "未知";
    }

    /**
     * 根据操作系统版本号得出操作系统内核类型
     *
     * @param osSerial
     * @return
     */
    public static String getOsType(String osSerial) {
        for (PcOsVersion e : PcOsVersion.values()) {
            if (e.getOsSerial().equals(osSerial)) {
                return e.getType();
            }
        }
        return "未知";
    }
}
