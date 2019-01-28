package com.example.javademo.enums;

public enum LogDescEnum {

    /**
     * 未知操作
     */
    LOGDESC_UNKNOWN(0, "未知操作"),
    /**
     * 登录操作
     */
    LOGDESC_LOGIN(1, "登录操作"),
    /**
     * 退出操作
     */
    LOGDESC_OUT(2, "退出操作"),
    /**
     * 添加
     */
    LOGDESC_ADD(3, "添加"),
    /**
     * 删除
     */
    LOGDESC_DELETE(4, "删除"),
    /**
     * 修改中心机房
     */
    LOGDESC_CHANGECENTERROOM(5, "修改中心机房"),
    /**
     * 实训室
     */
    LOGDESC_LABROOM(6, "实训室"),
    /**
     * 移动学生机
     */
    LOGDESC_MOVESTUDENTCOMPUTER(7, "移动学生机"),
    /**
     * 移动服务器
     */
    LOGDESC_MOVESERVICECOMPUTER(8, "服务器"),
    /**
     * 设置教师机
     */
    LOGDESC_SETTEACHERCOMPUTER(9, "设置教师机"),
    /**
     * 取消设置教师机
     */
    LOGDESC_GIVEUPSETTEACHER(10, "取消设置教师机"),
    /**
     * 添加子账号
     */
    LOGDESC_ADDCHILDACCOUNTS(11, "添加子账号"),
    /**
     * 设置子账号权限
     */
    LOGDESC_SETCHILDPOWER(12, "设置子账号权限"),
    /*
     * 设删除子账号
     */
    LOGDESC_DELETECHILDACCOUNT(13, "删除子账号"),
    /*
     * 机房检查
     */
    LOGDESC_CHECKGROUP(14, "机房检查"),
    /*
     * 学校信息修改
     */
    LOGDESC_SCHOOLINFO(15, "学校信息修改"),
    /**
     * 远程
     */
    LOGDESC_REMOTE(16, "远程"),
    /**
     * 修改
     */
    LOGDESC_EDIT(17, "修改"),
    /**
     * 远程
     */
    LOGDESC_CHECK(18, "机房检查"),
    /**
     * 远程命令
     */
    LOGDESC_REMOTE_COMMAND(19, "远程命令"),
    ;

    private Integer logDescId;
    private String logDescName;

    LogDescEnum(Integer logDescId, String logDescName) {
        this.logDescId = logDescId;
        this.logDescName = logDescName;
    }

    /**
     * 根据id获取操作名称
     *
     * @param logDescId
     * @return
     */
    public static String getLogDescNameById(Integer logDescId) {
        for (LogDescEnum logDescEnum : LogDescEnum.values()) {
            if (logDescEnum.getLogDescId().equals(logDescId)) {
                return logDescEnum.getLogDescName();
            }
        }
        return LOGDESC_UNKNOWN.getLogDescName();
    }

    public Integer getLogDescId() {
        return logDescId;
    }

    public void setLogDescId(Integer logDescId) {
        this.logDescId = logDescId;
    }

    public String getLogDescName() {
        return logDescName;
    }

    public void setLogDescName(String logDescName) {
        this.logDescName = logDescName;
    }




}
