/*     */ package org.apache.commons.net.ftp;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Formatter;
/*     */ import java.util.TimeZone;
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
/*     */ public class FTPFile
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 9010790363003271996L;
/*     */   public static final int FILE_TYPE = 0;
/*     */   public static final int DIRECTORY_TYPE = 1;
/*     */   public static final int SYMBOLIC_LINK_TYPE = 2;
/*     */   public static final int UNKNOWN_TYPE = 3;
/*     */   public static final int USER_ACCESS = 0;
/*     */   public static final int GROUP_ACCESS = 1;
/*     */   public static final int WORLD_ACCESS = 2;
/*     */   public static final int READ_PERMISSION = 0;
/*     */   public static final int WRITE_PERMISSION = 1;
/*     */   public static final int EXECUTE_PERMISSION = 2;
/*  67 */   private int type = 3;
/*     */ 
/*     */   
/*     */   private int hardLinkCount;
/*     */ 
/*     */   
/*  73 */   private long size = -1L;
/*     */   private String rawListing;
/*  75 */   private String user = "";
/*  76 */   private String group = "";
/*     */   
/*     */   private String name;
/*     */   
/*     */   private String link;
/*     */   
/*     */   private Calendar date;
/*     */   private final boolean[][] permissions;
/*     */   
/*     */   public FTPFile() {
/*  86 */     this.permissions = new boolean[3][3];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FTPFile(String paramString) {
/*  96 */     this.permissions = (boolean[][])null;
/*  97 */     this.rawListing = paramString;
/*     */   }
/*     */   
/*     */   private char formatType() {
/* 101 */     switch (this.type) {
/*     */       case 0:
/* 103 */         return '-';
/*     */       case 1:
/* 105 */         return 'd';
/*     */       case 2:
/* 107 */         return 'l';
/*     */     } 
/* 109 */     return '?';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 120 */     return this.group;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHardLinkCount() {
/* 129 */     return this.hardLinkCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLink() {
/* 139 */     return this.link;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 148 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRawListing() {
/* 157 */     return this.rawListing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 166 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Calendar getTimestamp() {
/* 175 */     return this.date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/* 185 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 194 */     return this.user;
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
/*     */   public boolean hasPermission(int paramInt1, int paramInt2) {
/* 207 */     if (this.permissions == null) {
/* 208 */       return false;
/*     */     }
/* 210 */     return this.permissions[paramInt1][paramInt2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDirectory() {
/* 219 */     return (this.type == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFile() {
/* 228 */     return (this.type == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSymbolicLink() {
/* 237 */     return (this.type == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnknown() {
/* 246 */     return (this.type == 3);
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
/*     */   
/*     */   public boolean isValid() {
/* 260 */     return (this.permissions != null);
/*     */   }
/*     */   
/*     */   private String permissionToString(int paramInt) {
/* 264 */     StringBuilder stringBuilder = new StringBuilder();
/* 265 */     if (hasPermission(paramInt, 0)) {
/* 266 */       stringBuilder.append('r');
/*     */     } else {
/* 268 */       stringBuilder.append('-');
/*     */     } 
/* 270 */     if (hasPermission(paramInt, 1)) {
/* 271 */       stringBuilder.append('w');
/*     */     } else {
/* 273 */       stringBuilder.append('-');
/*     */     } 
/* 275 */     if (hasPermission(paramInt, 2)) {
/* 276 */       stringBuilder.append('x');
/*     */     } else {
/* 278 */       stringBuilder.append('-');
/*     */     } 
/* 280 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroup(String paramString) {
/* 289 */     this.group = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHardLinkCount(int paramInt) {
/* 298 */     this.hardLinkCount = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLink(String paramString) {
/* 308 */     this.link = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 317 */     this.name = paramString;
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
/*     */   public void setPermission(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 330 */     this.permissions[paramInt1][paramInt2] = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRawListing(String paramString) {
/* 339 */     this.rawListing = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(long paramLong) {
/* 348 */     this.size = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(Calendar paramCalendar) {
/* 358 */     this.date = paramCalendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(int paramInt) {
/* 367 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser(String paramString) {
/* 376 */     this.user = paramString;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String toFormattedString() {
/* 392 */     return toFormattedString(null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toFormattedString(String paramString) {
/* 410 */     if (!isValid()) {
/* 411 */       return "[Invalid: could not parse file entry]";
/*     */     }
/* 413 */     StringBuilder stringBuilder = new StringBuilder();
/* 414 */     try (Formatter null = new Formatter(stringBuilder)) {
/* 415 */       stringBuilder.append(formatType());
/* 416 */       stringBuilder.append(permissionToString(0));
/* 417 */       stringBuilder.append(permissionToString(1));
/* 418 */       stringBuilder.append(permissionToString(2));
/* 419 */       formatter.format(" %4d", new Object[] { Integer.valueOf(getHardLinkCount()) });
/* 420 */       formatter.format(" %-8s %-8s", new Object[] { getUser(), getGroup() });
/* 421 */       formatter.format(" %8d", new Object[] { Long.valueOf(getSize()) });
/* 422 */       Calendar calendar = getTimestamp();
/* 423 */       if (calendar != null) {
/* 424 */         if (paramString != null) {
/* 425 */           TimeZone timeZone = TimeZone.getTimeZone(paramString);
/* 426 */           if (!timeZone.equals(calendar.getTimeZone())) {
/* 427 */             Date date = calendar.getTime();
/* 428 */             Calendar calendar1 = Calendar.getInstance(timeZone);
/* 429 */             calendar1.setTime(date);
/* 430 */             calendar = calendar1;
/*     */           } 
/*     */         } 
/* 433 */         formatter.format(" %1$tY-%1$tm-%1$td", new Object[] { calendar });
/*     */         
/* 435 */         if (calendar.isSet(11)) {
/* 436 */           formatter.format(" %1$tH", new Object[] { calendar });
/* 437 */           if (calendar.isSet(12)) {
/* 438 */             formatter.format(":%1$tM", new Object[] { calendar });
/* 439 */             if (calendar.isSet(13)) {
/* 440 */               formatter.format(":%1$tS", new Object[] { calendar });
/* 441 */               if (calendar.isSet(14)) {
/* 442 */                 formatter.format(".%1$tL", new Object[] { calendar });
/*     */               }
/*     */             } 
/*     */           } 
/* 446 */           formatter.format(" %1$tZ", new Object[] { calendar });
/*     */         } 
/*     */       } 
/* 449 */       stringBuilder.append(' ');
/* 450 */       stringBuilder.append(getName());
/*     */     } 
/* 452 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 462 */     return getRawListing();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */