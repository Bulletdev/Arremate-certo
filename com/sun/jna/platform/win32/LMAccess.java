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
/*     */ public interface LMAccess
/*     */ {
/*     */   public static final int FILTER_TEMP_DUPLICATE_ACCOUNT = 1;
/*     */   public static final int FILTER_NORMAL_ACCOUNT = 2;
/*     */   public static final int FILTER_INTERDOMAIN_TRUST_ACCOUNT = 8;
/*     */   public static final int FILTER_WORKSTATION_TRUST_ACCOUNT = 16;
/*     */   public static final int FILTER_SERVER_TRUST_ACCOUNT = 32;
/*     */   public static final int USER_PRIV_MASK = 3;
/*     */   public static final int USER_PRIV_GUEST = 0;
/*     */   public static final int USER_PRIV_USER = 1;
/*     */   public static final int USER_PRIV_ADMIN = 2;
/*     */   public static final int ACCESS_NONE = 0;
/*     */   public static final int ACCESS_READ = 1;
/*     */   public static final int ACCESS_WRITE = 2;
/*     */   public static final int ACCESS_CREATE = 4;
/*     */   public static final int ACCESS_EXEC = 8;
/*     */   public static final int ACCESS_DELETE = 16;
/*     */   public static final int ACCESS_ATRIB = 32;
/*     */   public static final int ACCESS_PERM = 64;
/*     */   public static final int ACCESS_ALL = 127;
/*     */   public static final int ACCESS_GROUP = 32768;
/*     */   
/*     */   @FieldOrder({"lgrui0_name"})
/*     */   public static class LOCALGROUP_INFO_0
/*     */     extends Structure
/*     */   {
/*     */     public String lgrui0_name;
/*     */     
/*     */     public LOCALGROUP_INFO_0() {
/*  46 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public LOCALGROUP_INFO_0(Pointer param1Pointer) {
/*  50 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/*  51 */       read();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"lgrui1_name", "lgrui1_comment"})
/*     */   public static class LOCALGROUP_INFO_1 extends Structure {
/*     */     public String lgrui1_name;
/*     */     public String lgrui1_comment;
/*     */     
/*     */     public LOCALGROUP_INFO_1() {
/*  61 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public LOCALGROUP_INFO_1(Pointer param1Pointer) {
/*  65 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/*  66 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"usri0_name"})
/*     */   public static class USER_INFO_0
/*     */     extends Structure
/*     */   {
/*     */     public String usri0_name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public USER_INFO_0() {
/*  92 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public USER_INFO_0(Pointer param1Pointer) {
/*  96 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/*  97 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"usri1_name", "usri1_password", "usri1_password_age", "usri1_priv", "usri1_home_dir", "usri1_comment", "usri1_flags", "usri1_script_path"})
/*     */   public static class USER_INFO_1
/*     */     extends Structure
/*     */   {
/*     */     public String usri1_name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri1_password;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int usri1_password_age;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int usri1_priv;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri1_home_dir;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri1_comment;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int usri1_flags;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri1_script_path;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public USER_INFO_1() {
/* 150 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public USER_INFO_1(Pointer param1Pointer) {
/* 154 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 155 */       read();
/*     */     }
/*     */   }
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
/*     */   @FieldOrder({"usri23_name", "usri23_full_name", "usri23_comment", "usri23_flags", "usri23_user_sid"})
/*     */   public static class USER_INFO_23
/*     */     extends Structure
/*     */   {
/*     */     public String usri23_name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri23_full_name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String usri23_comment;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int usri23_flags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.PSID.ByReference usri23_user_sid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public USER_INFO_23() {
/* 222 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public USER_INFO_23(Pointer param1Pointer) {
/* 226 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 227 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"grui0_name"})
/*     */   public static class GROUP_USERS_INFO_0
/*     */     extends Structure
/*     */   {
/*     */     public String grui0_name;
/*     */ 
/*     */ 
/*     */     
/*     */     public GROUP_USERS_INFO_0() {
/* 242 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public GROUP_USERS_INFO_0(Pointer param1Pointer) {
/* 246 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 247 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"lgrui0_name"})
/*     */   public static class LOCALGROUP_USERS_INFO_0
/*     */     extends Structure
/*     */   {
/*     */     public String lgrui0_name;
/*     */ 
/*     */ 
/*     */     
/*     */     public LOCALGROUP_USERS_INFO_0() {
/* 262 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public LOCALGROUP_USERS_INFO_0(Pointer param1Pointer) {
/* 266 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 267 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"grpi0_name"})
/*     */   public static class GROUP_INFO_0
/*     */     extends Structure
/*     */   {
/*     */     public String grpi0_name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GROUP_INFO_0() {
/* 285 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public GROUP_INFO_0(Pointer param1Pointer) {
/* 289 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 290 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"grpi1_name", "grpi1_comment"})
/*     */   public static class GROUP_INFO_1
/*     */     extends Structure
/*     */   {
/*     */     public String grpi1_name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String grpi1_comment;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GROUP_INFO_1() {
/* 313 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public GROUP_INFO_1(Pointer param1Pointer) {
/* 317 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 318 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"grpi2_name", "grpi2_comment", "grpi2_group_id", "grpi2_attributes"})
/*     */   public static class GROUP_INFO_2
/*     */     extends Structure
/*     */   {
/*     */     public String grpi2_name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String grpi2_comment;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int grpi2_group_id;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int grpi2_attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GROUP_INFO_2() {
/* 351 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public GROUP_INFO_2(Pointer param1Pointer) {
/* 355 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 356 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"grpi3_name", "grpi3_comment", "grpi3_group_sid", "grpi3_attributes"})
/*     */   public static class GROUP_INFO_3
/*     */     extends Structure
/*     */   {
/*     */     public String grpi3_name;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String grpi3_comment;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.PSID.ByReference grpi3_group_sid;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int grpi3_attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GROUP_INFO_3() {
/* 389 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public GROUP_INFO_3(Pointer param1Pointer) {
/* 393 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 394 */       read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\LMAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */