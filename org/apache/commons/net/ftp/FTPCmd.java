/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum FTPCmd
/*     */ {
/*     */   public static final FTPCmd ABORT;
/*     */   public static final FTPCmd ACCOUNT;
/*     */   public static final FTPCmd ALLOCATE;
/*     */   public static final FTPCmd APPEND;
/*     */   public static final FTPCmd CHANGE_TO_PARENT_DIRECTORY;
/*     */   public static final FTPCmd CHANGE_WORKING_DIRECTORY;
/*     */   public static final FTPCmd DATA_PORT;
/*     */   public static final FTPCmd DELETE;
/*     */   public static final FTPCmd FEATURES;
/*     */   public static final FTPCmd FILE_STRUCTURE;
/*     */   public static final FTPCmd GET_MOD_TIME;
/*     */   public static final FTPCmd LOGOUT;
/*     */   public static final FTPCmd MAKE_DIRECTORY;
/*     */   public static final FTPCmd MOD_TIME;
/*     */   public static final FTPCmd NAME_LIST;
/*  25 */   ABOR,
/*  26 */   ACCT,
/*  27 */   ALLO,
/*  28 */   APPE,
/*  29 */   CDUP,
/*  30 */   CWD,
/*  31 */   DELE,
/*  32 */   EPRT,
/*  33 */   EPSV,
/*  34 */   FEAT,
/*  35 */   HELP,
/*  36 */   LIST,
/*  37 */   MDTM,
/*  38 */   MFMT,
/*  39 */   MKD,
/*  40 */   MLSD,
/*  41 */   MLST,
/*  42 */   MODE,
/*  43 */   NLST,
/*  44 */   NOOP,
/*  45 */   PASS,
/*  46 */   PASV,
/*  47 */   PORT,
/*  48 */   PWD,
/*  49 */   QUIT,
/*  50 */   REIN,
/*  51 */   REST,
/*  52 */   RETR,
/*  53 */   RMD,
/*  54 */   RNFR,
/*  55 */   RNTO,
/*  56 */   SITE,
/*     */   
/*  58 */   SIZE,
/*  59 */   SMNT,
/*  60 */   STAT,
/*  61 */   STOR,
/*  62 */   STOU,
/*  63 */   STRU,
/*  64 */   SYST,
/*  65 */   TYPE,
/*  66 */   USER;
/*     */   public static final FTPCmd PASSIVE;
/*     */   public static final FTPCmd PASSWORD;
/*     */   
/*     */   static {
/*  71 */     ABORT = ABOR;
/*  72 */     ACCOUNT = ACCT;
/*  73 */     ALLOCATE = ALLO;
/*  74 */     APPEND = APPE;
/*  75 */     CHANGE_TO_PARENT_DIRECTORY = CDUP;
/*  76 */     CHANGE_WORKING_DIRECTORY = CWD;
/*  77 */     DATA_PORT = PORT;
/*  78 */     DELETE = DELE;
/*  79 */     FEATURES = FEAT;
/*  80 */     FILE_STRUCTURE = STRU;
/*  81 */     GET_MOD_TIME = MDTM;
/*  82 */     LOGOUT = QUIT;
/*  83 */     MAKE_DIRECTORY = MKD;
/*  84 */     MOD_TIME = MDTM;
/*  85 */     NAME_LIST = NLST;
/*  86 */     PASSIVE = PASV;
/*  87 */     PASSWORD = PASS;
/*  88 */     PRINT_WORKING_DIRECTORY = PWD;
/*  89 */     REINITIALIZE = REIN;
/*  90 */     REMOVE_DIRECTORY = RMD;
/*  91 */     RENAME_FROM = RNFR;
/*  92 */     RENAME_TO = RNTO;
/*  93 */     REPRESENTATION_TYPE = TYPE;
/*  94 */     RESTART = REST;
/*  95 */     RETRIEVE = RETR;
/*  96 */     SET_MOD_TIME = MFMT;
/*  97 */     SITE_PARAMETERS = SITE;
/*  98 */     STATUS = STAT;
/*  99 */     STORE = STOR;
/* 100 */     STORE_UNIQUE = STOU;
/* 101 */     STRUCTURE_MOUNT = SMNT;
/* 102 */     SYSTEM = SYST;
/* 103 */     TRANSFER_MODE = MODE;
/* 104 */     USERNAME = USER;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final FTPCmd PRINT_WORKING_DIRECTORY;
/*     */   
/*     */   public static final FTPCmd REINITIALIZE;
/*     */   public static final FTPCmd REMOVE_DIRECTORY;
/*     */   public static final FTPCmd RENAME_FROM;
/*     */   
/*     */   public final String getCommand() {
/* 115 */     return name();
/*     */   }
/*     */   
/*     */   public static final FTPCmd RENAME_TO;
/*     */   public static final FTPCmd REPRESENTATION_TYPE;
/*     */   public static final FTPCmd RESTART;
/*     */   public static final FTPCmd RETRIEVE;
/*     */   public static final FTPCmd SET_MOD_TIME;
/*     */   public static final FTPCmd SITE_PARAMETERS;
/*     */   public static final FTPCmd STATUS;
/*     */   public static final FTPCmd STORE;
/*     */   public static final FTPCmd STORE_UNIQUE;
/*     */   public static final FTPCmd STRUCTURE_MOUNT;
/*     */   public static final FTPCmd SYSTEM;
/*     */   public static final FTPCmd TRANSFER_MODE;
/*     */   public static final FTPCmd USERNAME;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPCmd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */