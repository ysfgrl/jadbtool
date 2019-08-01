/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

/**
 *
 * @author yusuf
 */
public class Adbdevice {

    private String serial;
    private String versionid;
    private String version;

    public Adbdevice() {
    }

    
    public Adbdevice(String serial) {
        this.serial = serial;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the versionid
     */
    public String getVersionid() {
        return versionid;
    }

    /**
     * @param versionid the versionid to set
     */
    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
