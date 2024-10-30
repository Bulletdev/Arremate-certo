/*    */ package oshi.jna.platform.unix.solaris;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.NativeLong;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
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
/*    */ public interface SolarisLibc
/*    */   extends CLibrary
/*    */ {
/* 39 */   public static final SolarisLibc INSTANCE = (SolarisLibc)Native.load("c", SolarisLibc.class);
/*    */   public static final int UTX_USERSIZE = 32;
/*    */   public static final int UTX_LINESIZE = 32;
/*    */   public static final int UTX_IDSIZE = 4;
/*    */   public static final int UTX_HOSTSIZE = 257;
/*    */   
/*    */   SolarisUtmpx getutxent();
/*    */   
/*    */   @FieldOrder({"ut_user", "ut_id", "ut_line", "ut_pid", "ut_type", "ut_tv", "ut_session", "ut_syslen", "ut_host"})
/*    */   public static class SolarisUtmpx
/*    */     extends Structure
/*    */   {
/* 51 */     public byte[] ut_user = new byte[32];
/* 52 */     public byte[] ut_id = new byte[4];
/* 53 */     public byte[] ut_line = new byte[32];
/*    */     public int ut_pid;
/*    */     public short ut_type;
/*    */     public SolarisLibc.Timeval ut_tv;
/*    */     public int ut_session;
/*    */     public short ut_syslen;
/* 59 */     public byte[] ut_host = new byte[257];
/*    */   }
/*    */   
/*    */   @FieldOrder({"e_termination", "e_exit"})
/*    */   public static class Exit_status extends Structure {
/*    */     public short e_termination;
/*    */     public short e_exit;
/*    */   }
/*    */   
/*    */   @FieldOrder({"tv_sec", "tv_usec"})
/*    */   public static class Timeval extends Structure {
/*    */     public NativeLong tv_sec;
/*    */     public NativeLong tv_usec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platfor\\unix\solaris\SolarisLibc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */