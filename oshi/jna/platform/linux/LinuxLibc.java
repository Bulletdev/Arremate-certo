/*    */ package oshi.jna.platform.linux;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.platform.linux.LibC;
/*    */ import oshi.jna.platform.unix.CLibrary;
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
/*    */ public interface LinuxLibc
/*    */   extends LibC, CLibrary
/*    */ {
/* 39 */   public static final LinuxLibc INSTANCE = (LinuxLibc)Native.load("c", LinuxLibc.class);
/*    */   
/*    */   LinuxUtmpx getutxent();
/*    */   
/*    */   @FieldOrder({"ut_type", "ut_pid", "ut_line", "ut_id", "ut_user", "ut_host", "ut_exit", "ut_session", "ut_tv", "ut_addr_v6", "reserved"})
/*    */   public static class LinuxUtmpx
/*    */     extends Structure
/*    */   {
/*    */     public short ut_type;
/*    */     public int ut_pid;
/* 49 */     public byte[] ut_line = new byte[32];
/* 50 */     public byte[] ut_id = new byte[4];
/* 51 */     public byte[] ut_user = new byte[32];
/* 52 */     public byte[] ut_host = new byte[256];
/*    */     public LinuxLibc.Exit_status ut_exit;
/*    */     public int ut_session;
/*    */     public LinuxLibc.Ut_Tv ut_tv;
/* 56 */     public int[] ut_addr_v6 = new int[4];
/* 57 */     public byte[] reserved = new byte[20];
/*    */   }
/*    */   
/*    */   @FieldOrder({"e_termination", "e_exit"})
/*    */   public static class Exit_status extends Structure {
/*    */     public short e_termination;
/*    */     public short e_exit;
/*    */   }
/*    */   
/*    */   @FieldOrder({"tv_sec", "tv_usec"})
/*    */   public static class Ut_Tv extends Structure {
/*    */     public int tv_sec;
/*    */     public int tv_usec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\linux\LinuxLibc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */