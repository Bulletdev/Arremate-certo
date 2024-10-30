/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.win32.W32APITypeMapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface LMShare
/*     */ {
/*     */   public static final int STYPE_DISKTREE = 0;
/*     */   public static final int STYPE_PRINTQ = 1;
/*     */   public static final int STYPE_DEVICE = 2;
/*     */   public static final int STYPE_IPC = 3;
/*     */   public static final int STYPE_TEMPORARY = 1073741824;
/*     */   public static final int STYPE_SPECIAL = -2147483648;
/*     */   
/*     */   @FieldOrder({"shi2_netname", "shi2_type", "shi2_remark", "shi2_permissions", "shi2_max_uses", "shi2_current_uses", "shi2_path", "shi2_passwd"})
/*     */   public static class SHARE_INFO_2
/*     */     extends Structure
/*     */   {
/*     */     public String shi2_netname;
/*     */     public int shi2_type;
/*     */     public String shi2_remark;
/*     */     public int shi2_permissions;
/*     */     public int shi2_max_uses;
/*     */     public int shi2_current_uses;
/*     */     public String shi2_path;
/*     */     public String shi2_passwd;
/*     */     
/*     */     public SHARE_INFO_2() {
/* 132 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public SHARE_INFO_2(Pointer param1Pointer) {
/* 136 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 137 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"shi502_netname", "shi502_type", "shi502_remark", "shi502_permissions", "shi502_max_uses", "shi502_current_uses", "shi502_path", "shi502_passwd", "shi502_reserved", "shi502_security_descriptor"})
/*     */   public static class SHARE_INFO_502
/*     */     extends Structure
/*     */   {
/*     */     public String shi502_netname;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int shi502_type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String shi502_remark;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int shi502_permissions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int shi502_max_uses;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int shi502_current_uses;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String shi502_path;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String shi502_passwd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int shi502_reserved;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Pointer shi502_security_descriptor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SHARE_INFO_502() {
/* 210 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public SHARE_INFO_502(Pointer param1Pointer) {
/* 214 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 215 */       read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\LMShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */