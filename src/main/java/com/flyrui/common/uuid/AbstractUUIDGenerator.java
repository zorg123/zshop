package com.flyrui.common.uuid;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import sun.management.VMManagement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;

public class AbstractUUIDGenerator {
	private static final int IP;
    static {
        int ipadd;
        try {
            ipadd = toInt(InetAddress.getLocalHost().getAddress());
        } catch (final Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
 
    public static int toInt(final byte[] bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = (result << 8) - Byte.MIN_VALUE + bytes[i];
        }
        return result;
    }
 
    private static short counter = (short) 0;
    private static int JVM = (int) (System.currentTimeMillis() >>> 8);
    static {
    	try {  
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
            Field jvm = runtime.getClass().getDeclaredField("jvm");  
            jvm.setAccessible(true);
            VMManagement mgmt = (VMManagement) jvm.get(runtime);  
            Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");  
            pidMethod.setAccessible(true);  
            JVM = (Integer) pidMethod.invoke(mgmt); 
        } catch (Exception e) {  
            
        }
    }
 
    public AbstractUUIDGenerator() {
    }
 
    /**
     * Unique across JVMs on this machine (unless they load this class
     * in the same quater second - very unlikely)
     */
    protected int getJVM() {
        return JVM;
    }
 
    /**
     * Unique in a millisecond for this JVM instance (unless there
     * are > Short.MAX_VALUE instances created in a millisecond)
     */
    protected short getCount() {
        synchronized (AbstractUUIDGenerator.class) {
            if (counter < 0)
                counter = 0;
            return counter++;
        }
    }
 
    /**
     * Unique in a local network
     */
    protected int getIP() {
        return IP;
    }
 
    /**
     * Unique down to millisecond
     */
    protected short getHiTime() {
        return (short) (System.currentTimeMillis() >>> 32);
    }
 
    protected int getLoTime() {
        return (int) System.currentTimeMillis();
    }

    public static final int jvmPid() {  
        try {  
            RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();  
            Field jvm = runtime.getClass().getDeclaredField("jvm");  
            jvm.setAccessible(true);
            VMManagement mgmt = (VMManagement) jvm.get(runtime);  
            Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");  
            pidMethod.setAccessible(true);  
            int pid = (Integer) pidMethod.invoke(mgmt);  
            return pid;  
        } catch (Exception e) {  
            return -1;  
        }  
    } 
}
