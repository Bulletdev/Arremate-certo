/*    */ package oshi.util;
/*    */ 
/*    */ import java.time.Instant;
/*    */ import java.time.OffsetDateTime;
/*    */ import java.time.ZoneOffset;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Constants
/*    */ {
/*    */   public static final String UNKNOWN = "unknown";
/*    */   public static final String SYSFS_SERIAL_PATH = "/sys/devices/virtual/dmi/id/";
/* 52 */   public static final OffsetDateTime UNIX_EPOCH = OffsetDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Constants() {
/* 58 */     throw new AssertionError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\Constants.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */