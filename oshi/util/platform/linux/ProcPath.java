/*    */ package oshi.util.platform.linux;
/*    */ 
/*    */ import java.io.File;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.GlobalConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class ProcPath
/*    */ {
/* 44 */   public static final String PROC = queryProcConfig();
/*    */   
/* 46 */   public static final String ASOUND = PROC + "/asound/";
/* 47 */   public static final String CPUINFO = PROC + "/cpuinfo";
/* 48 */   public static final String DISKSTATS = PROC + "/diskstats";
/* 49 */   public static final String MEMINFO = PROC + "/meminfo";
/* 50 */   public static final String MOUNTS = PROC + "/mounts";
/* 51 */   public static final String NET = PROC + "/net";
/* 52 */   public static final String PID_CMDLINE = PROC + "/%d/cmdline";
/* 53 */   public static final String PID_CWD = PROC + "/%d/cwd";
/* 54 */   public static final String PID_EXE = PROC + "/%d/exe";
/* 55 */   public static final String PID_ENVIRON = PROC + "/%d/environ";
/* 56 */   public static final String PID_FD = PROC + "/%d/fd";
/* 57 */   public static final String PID_IO = PROC + "/%d/io";
/* 58 */   public static final String PID_STAT = PROC + "/%d/stat";
/* 59 */   public static final String PID_STATM = PROC + "/%d/statm";
/* 60 */   public static final String PID_STATUS = PROC + "/%d/status";
/* 61 */   public static final String SELF_STAT = PROC + "/self/stat";
/* 62 */   public static final String STAT = PROC + "/stat";
/* 63 */   public static final String SYS_FS_FILE_NR = PROC + "/sys/fs/file-nr";
/* 64 */   public static final String TASK_PATH = PROC + "/%d/task";
/* 65 */   public static final String TASK_COMM = TASK_PATH + "/%d/comm";
/* 66 */   public static final String TASK_STATUS = TASK_PATH + "/%d/status";
/* 67 */   public static final String TASK_STAT = TASK_PATH + "/%d/stat";
/* 68 */   public static final String UPTIME = PROC + "/uptime";
/* 69 */   public static final String VERSION = PROC + "/version";
/* 70 */   public static final String VMSTAT = PROC + "/vmstat";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static String queryProcConfig() {
/* 76 */     String str = GlobalConfig.get("oshi.util.proc.path", "/proc");
/*    */     
/* 78 */     str = '/' + str.replaceAll("/$|^/", "");
/* 79 */     if (!(new File(str)).exists()) {
/* 80 */       throw new GlobalConfig.PropertyException("oshi.util.proc.path", "The path does not exist");
/*    */     }
/* 82 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\linux\ProcPath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */