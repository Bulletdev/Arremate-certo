/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Properties;
/*     */ import org.h2.command.dml.SetTypes;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.store.fs.FilePathEncrypt;
/*     */ import org.h2.store.fs.FilePathRec;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.SortedProperties;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConnectionInfo
/*     */   implements Cloneable
/*     */ {
/*  31 */   private static final HashSet<String> KNOWN_SETTINGS = New.hashSet();
/*     */   
/*  33 */   private Properties prop = new Properties();
/*     */   
/*     */   private String originalURL;
/*     */   
/*     */   private String url;
/*     */   
/*     */   private String user;
/*     */   
/*     */   private byte[] filePasswordHash;
/*     */   
/*     */   private byte[] fileEncryptionKey;
/*     */   
/*     */   private byte[] userPasswordHash;
/*     */   
/*     */   private String name;
/*     */   
/*     */   private String nameNormalized;
/*     */   
/*     */   private boolean remote;
/*     */   
/*     */   private boolean ssl;
/*     */   private boolean persistent;
/*     */   private boolean unnamed;
/*     */   
/*     */   public ConnectionInfo(String paramString) {
/*  58 */     this.name = paramString;
/*  59 */     this.url = "jdbc:h2:" + paramString;
/*  60 */     parseName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConnectionInfo(String paramString, Properties paramProperties) {
/*  70 */     paramString = remapURL(paramString);
/*  71 */     this.originalURL = paramString;
/*  72 */     if (!paramString.startsWith("jdbc:h2:")) {
/*  73 */       throw DbException.getInvalidValueException("url", paramString);
/*     */     }
/*  75 */     this.url = paramString;
/*  76 */     readProperties(paramProperties);
/*  77 */     readSettingsFromURL();
/*  78 */     setUserName(removeProperty("USER", ""));
/*  79 */     convertPasswords();
/*  80 */     this.name = this.url.substring("jdbc:h2:".length());
/*  81 */     parseName();
/*  82 */     String str = removeProperty("RECOVER_TEST", (String)null);
/*  83 */     if (str != null) {
/*  84 */       FilePathRec.register();
/*     */       try {
/*  86 */         Utils.callStaticMethod("org.h2.store.RecoverTester.init", new Object[] { str });
/*  87 */       } catch (Exception exception) {
/*  88 */         throw DbException.convert(exception);
/*     */       } 
/*  90 */       this.name = "rec:" + this.name;
/*     */     } 
/*     */   }
/*     */   
/*     */   static {
/*  95 */     ArrayList<? extends String> arrayList = SetTypes.getTypes();
/*  96 */     HashSet<String> hashSet = KNOWN_SETTINGS;
/*  97 */     hashSet.addAll(arrayList);
/*  98 */     String[] arrayOfString = { "ACCESS_MODE_DATA", "AUTOCOMMIT", "CIPHER", "CREATE", "CACHE_TYPE", "FILE_LOCK", "IGNORE_UNKNOWN_SETTINGS", "IFEXISTS", "INIT", "PASSWORD", "RECOVER", "RECOVER_TEST", "USER", "AUTO_SERVER", "AUTO_SERVER_PORT", "NO_UPGRADE", "AUTO_RECONNECT", "OPEN_NEW", "PAGE_SIZE", "PASSWORD_HASH", "JMX" };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     for (String str : arrayOfString) {
/* 104 */       if (SysProperties.CHECK && hashSet.contains(str)) {
/* 105 */         DbException.throwInternalError(str);
/*     */       }
/* 107 */       hashSet.add(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isKnownSetting(String paramString) {
/* 112 */     return KNOWN_SETTINGS.contains(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConnectionInfo clone() throws CloneNotSupportedException {
/* 117 */     ConnectionInfo connectionInfo = (ConnectionInfo)super.clone();
/* 118 */     connectionInfo.prop = (Properties)this.prop.clone();
/* 119 */     connectionInfo.filePasswordHash = Utils.cloneByteArray(this.filePasswordHash);
/* 120 */     connectionInfo.fileEncryptionKey = Utils.cloneByteArray(this.fileEncryptionKey);
/* 121 */     connectionInfo.userPasswordHash = Utils.cloneByteArray(this.userPasswordHash);
/* 122 */     return connectionInfo;
/*     */   }
/*     */   
/*     */   private void parseName() {
/* 126 */     if (".".equals(this.name)) {
/* 127 */       this.name = "mem:";
/*     */     }
/* 129 */     if (this.name.startsWith("tcp:")) {
/* 130 */       this.remote = true;
/* 131 */       this.name = this.name.substring("tcp:".length());
/* 132 */     } else if (this.name.startsWith("ssl:")) {
/* 133 */       this.remote = true;
/* 134 */       this.ssl = true;
/* 135 */       this.name = this.name.substring("ssl:".length());
/* 136 */     } else if (this.name.startsWith("mem:")) {
/* 137 */       this.persistent = false;
/* 138 */       if ("mem:".equals(this.name)) {
/* 139 */         this.unnamed = true;
/*     */       }
/* 141 */     } else if (this.name.startsWith("file:")) {
/* 142 */       this.name = this.name.substring("file:".length());
/* 143 */       this.persistent = true;
/*     */     } else {
/* 145 */       this.persistent = true;
/*     */     } 
/* 147 */     if (this.persistent && !this.remote) {
/* 148 */       if ("/".equals(SysProperties.FILE_SEPARATOR)) {
/* 149 */         this.name = this.name.replace('\\', '/');
/*     */       } else {
/* 151 */         this.name = this.name.replace('/', '\\');
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseDir(String paramString) {
/* 163 */     if (this.persistent) {
/* 164 */       String str2, str1 = FileUtils.unwrap(FileUtils.toRealPath(paramString));
/* 165 */       boolean bool = FileUtils.isAbsolute(this.name);
/*     */       
/* 167 */       String str3 = null;
/* 168 */       if (paramString.endsWith(SysProperties.FILE_SEPARATOR)) {
/* 169 */         paramString = paramString.substring(0, paramString.length() - 1);
/*     */       }
/* 171 */       if (bool) {
/* 172 */         str2 = this.name;
/*     */       } else {
/* 174 */         str2 = FileUtils.unwrap(this.name);
/* 175 */         str3 = this.name.substring(0, this.name.length() - str2.length());
/* 176 */         str2 = paramString + SysProperties.FILE_SEPARATOR + str2;
/*     */       } 
/* 178 */       String str4 = FileUtils.unwrap(FileUtils.toRealPath(str2));
/* 179 */       if (str4.equals(str1) || !str4.startsWith(str1))
/*     */       {
/*     */         
/* 182 */         throw DbException.get(90028, str4 + " outside " + str1);
/*     */       }
/*     */       
/* 185 */       if (!str1.endsWith("/") && !str1.endsWith("\\"))
/*     */       {
/* 187 */         if (str4.charAt(str1.length()) != '/')
/*     */         {
/*     */ 
/*     */           
/* 191 */           throw DbException.get(90028, str4 + " outside " + str1);
/*     */         }
/*     */       }
/* 194 */       if (!bool) {
/* 195 */         this.name = str3 + paramString + SysProperties.FILE_SEPARATOR + FileUtils.unwrap(this.name);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRemote() {
/* 206 */     return this.remote;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPersistent() {
/* 215 */     return this.persistent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isUnnamedInMemory() {
/* 224 */     return this.unnamed;
/*     */   }
/*     */   
/*     */   private void readProperties(Properties paramProperties) {
/* 228 */     Object[] arrayOfObject = new Object[paramProperties.size()];
/* 229 */     paramProperties.keySet().toArray(arrayOfObject);
/* 230 */     DbSettings dbSettings = null;
/* 231 */     for (Object object1 : arrayOfObject) {
/* 232 */       String str = StringUtils.toUpperEnglish(object1.toString());
/* 233 */       if (this.prop.containsKey(str)) {
/* 234 */         throw DbException.get(90066, str);
/*     */       }
/* 236 */       Object object2 = paramProperties.get(object1);
/* 237 */       if (isKnownSetting(str)) {
/* 238 */         this.prop.put(str, object2);
/*     */       } else {
/* 240 */         if (dbSettings == null) {
/* 241 */           dbSettings = getDbSettings();
/*     */         }
/* 243 */         if (dbSettings.containsKey(str)) {
/* 244 */           this.prop.put(str, object2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void readSettingsFromURL() {
/* 251 */     DbSettings dbSettings = DbSettings.getDefaultSettings();
/* 252 */     int i = this.url.indexOf(';');
/* 253 */     if (i >= 0) {
/* 254 */       String str = this.url.substring(i + 1);
/* 255 */       this.url = this.url.substring(0, i);
/* 256 */       String[] arrayOfString = StringUtils.arraySplit(str, ';', false);
/* 257 */       for (String str1 : arrayOfString) {
/* 258 */         if (str1.length() != 0) {
/*     */ 
/*     */           
/* 261 */           int j = str1.indexOf('=');
/* 262 */           if (j < 0) {
/* 263 */             throw getFormatException();
/*     */           }
/* 265 */           String str2 = str1.substring(j + 1);
/* 266 */           String str3 = str1.substring(0, j);
/* 267 */           str3 = StringUtils.toUpperEnglish(str3);
/* 268 */           if (!isKnownSetting(str3) && !dbSettings.containsKey(str3)) {
/* 269 */             throw DbException.get(90113, str3);
/*     */           }
/* 271 */           String str4 = this.prop.getProperty(str3);
/* 272 */           if (str4 != null && !str4.equals(str2)) {
/* 273 */             throw DbException.get(90066, str3);
/*     */           }
/* 275 */           this.prop.setProperty(str3, str2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private char[] removePassword() {
/* 281 */     Object object = this.prop.remove("PASSWORD");
/* 282 */     if (object == null)
/* 283 */       return new char[0]; 
/* 284 */     if (object instanceof char[]) {
/* 285 */       return (char[])object;
/*     */     }
/* 287 */     return object.toString().toCharArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void convertPasswords() {
/* 296 */     char[] arrayOfChar = removePassword();
/* 297 */     boolean bool = removeProperty("PASSWORD_HASH", false);
/* 298 */     if (getProperty("CIPHER", (String)null) != null) {
/*     */       
/* 300 */       byte b = -1; byte b1; int i;
/* 301 */       for (b1 = 0, i = arrayOfChar.length; b1 < i; b1++) {
/* 302 */         if (arrayOfChar[b1] == ' ') {
/* 303 */           b = b1;
/*     */           break;
/*     */         } 
/*     */       } 
/* 307 */       if (b < 0) {
/* 308 */         throw DbException.get(90050);
/*     */       }
/* 310 */       char[] arrayOfChar1 = new char[arrayOfChar.length - b - 1];
/* 311 */       char[] arrayOfChar2 = new char[b];
/* 312 */       System.arraycopy(arrayOfChar, b + 1, arrayOfChar1, 0, arrayOfChar1.length);
/* 313 */       System.arraycopy(arrayOfChar, 0, arrayOfChar2, 0, b);
/* 314 */       Arrays.fill(arrayOfChar, false);
/* 315 */       arrayOfChar = arrayOfChar1;
/* 316 */       this.fileEncryptionKey = FilePathEncrypt.getPasswordBytes(arrayOfChar2);
/* 317 */       this.filePasswordHash = hashPassword(bool, "file", arrayOfChar2);
/*     */     } 
/* 319 */     this.userPasswordHash = hashPassword(bool, this.user, arrayOfChar);
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] hashPassword(boolean paramBoolean, String paramString, char[] paramArrayOfchar) {
/* 324 */     if (paramBoolean) {
/* 325 */       return StringUtils.convertHexToBytes(new String(paramArrayOfchar));
/*     */     }
/* 327 */     if (paramString.length() == 0 && paramArrayOfchar.length == 0) {
/* 328 */       return new byte[0];
/*     */     }
/* 330 */     return SHA256.getKeyPasswordHash(paramString, paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getProperty(String paramString, boolean paramBoolean) {
/* 341 */     String str = getProperty(paramString, (String)null);
/* 342 */     if (str == null) {
/* 343 */       return paramBoolean;
/*     */     }
/*     */     
/* 346 */     if (str.length() == 1 && Character.isDigit(str.charAt(0))) {
/* 347 */       return (Integer.parseInt(str) != 0);
/*     */     }
/* 349 */     return Boolean.parseBoolean(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeProperty(String paramString, boolean paramBoolean) {
/* 360 */     String str = removeProperty(paramString, (String)null);
/* 361 */     return (str == null) ? paramBoolean : Boolean.parseBoolean(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String removeProperty(String paramString1, String paramString2) {
/* 372 */     if (SysProperties.CHECK && !isKnownSetting(paramString1)) {
/* 373 */       DbException.throwInternalError(paramString1);
/*     */     }
/* 375 */     Object object = this.prop.remove(paramString1);
/* 376 */     return (object == null) ? paramString2 : object.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 385 */     if (!this.persistent) {
/* 386 */       return this.name;
/*     */     }
/* 388 */     if (this.nameNormalized == null) {
/* 389 */       String str2; if (!SysProperties.IMPLICIT_RELATIVE_PATH && 
/* 390 */         !FileUtils.isAbsolute(this.name) && 
/* 391 */         this.name.indexOf("./") < 0 && this.name.indexOf(".\\") < 0 && this.name.indexOf(":/") < 0 && this.name.indexOf(":\\") < 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 400 */         throw DbException.get(90011, this.originalURL);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 406 */       String str1 = ".h2.db";
/*     */       
/* 408 */       if (FileUtils.exists(this.name + str1)) {
/* 409 */         str2 = FileUtils.toRealPath(this.name + str1);
/*     */       } else {
/* 411 */         str1 = ".mv.db";
/* 412 */         str2 = FileUtils.toRealPath(this.name + str1);
/*     */       } 
/* 414 */       String str3 = FileUtils.getName(str2);
/* 415 */       if (str3.length() < str1.length() + 1) {
/* 416 */         throw DbException.get(90138, this.name);
/*     */       }
/* 418 */       this.nameNormalized = str2.substring(0, str2.length() - str1.length());
/*     */     } 
/* 420 */     return this.nameNormalized;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getFilePasswordHash() {
/* 429 */     return this.filePasswordHash;
/*     */   }
/*     */   
/*     */   byte[] getFileEncryptionKey() {
/* 433 */     return this.fileEncryptionKey;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserName() {
/* 442 */     return this.user;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   byte[] getUserPasswordHash() {
/* 451 */     return this.userPasswordHash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String[] getKeys() {
/* 460 */     String[] arrayOfString = new String[this.prop.size()];
/* 461 */     this.prop.keySet().toArray((Object[])arrayOfString);
/* 462 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getProperty(String paramString) {
/* 472 */     Object object = this.prop.get(paramString);
/* 473 */     if (object == null || !(object instanceof String)) {
/* 474 */       return null;
/*     */     }
/* 476 */     return object.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getProperty(String paramString, int paramInt) {
/* 487 */     if (SysProperties.CHECK && !isKnownSetting(paramString)) {
/* 488 */       DbException.throwInternalError(paramString);
/*     */     }
/* 490 */     String str = getProperty(paramString);
/* 491 */     return (str == null) ? paramInt : Integer.parseInt(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getProperty(String paramString1, String paramString2) {
/* 502 */     if (SysProperties.CHECK && !isKnownSetting(paramString1)) {
/* 503 */       DbException.throwInternalError(paramString1);
/*     */     }
/* 505 */     String str = getProperty(paramString1);
/* 506 */     return (str == null) ? paramString2 : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getProperty(int paramInt, String paramString) {
/* 517 */     String str1 = SetTypes.getTypeName(paramInt);
/* 518 */     String str2 = getProperty(str1);
/* 519 */     return (str2 == null) ? paramString : str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getIntProperty(int paramInt1, int paramInt2) {
/* 530 */     String str1 = SetTypes.getTypeName(paramInt1);
/* 531 */     String str2 = getProperty(str1, (String)null);
/*     */     try {
/* 533 */       return (str2 == null) ? paramInt2 : Integer.decode(str2).intValue();
/* 534 */     } catch (NumberFormatException numberFormatException) {
/* 535 */       return paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSSL() {
/* 545 */     return this.ssl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserName(String paramString) {
/* 555 */     this.user = StringUtils.toUpperEnglish(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUserPasswordHash(byte[] paramArrayOfbyte) {
/* 564 */     this.userPasswordHash = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFilePasswordHash(byte[] paramArrayOfbyte) {
/* 573 */     this.filePasswordHash = paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public void setFileEncryptionKey(byte[] paramArrayOfbyte) {
/* 577 */     this.fileEncryptionKey = paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperty(String paramString1, String paramString2) {
/* 588 */     if (paramString2 != null) {
/* 589 */       this.prop.setProperty(paramString1, paramString2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getURL() {
/* 599 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOriginalURL() {
/* 608 */     return this.originalURL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOriginalURL(String paramString) {
/* 617 */     this.originalURL = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DbException getFormatException() {
/* 626 */     String str = "jdbc:h2:{ {.|mem:}[name] | [file:]fileName | {tcp|ssl}:[//]server[:port][,server2[:port]]/name }[;key=value...]";
/* 627 */     return DbException.get(90046, new String[] { str, this.url });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServerKey(String paramString) {
/* 636 */     this.remote = true;
/* 637 */     this.persistent = false;
/* 638 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public DbSettings getDbSettings() {
/* 642 */     DbSettings dbSettings = DbSettings.getDefaultSettings();
/* 643 */     HashMap<String, String> hashMap = New.hashMap();
/* 644 */     for (Object object : this.prop.keySet()) {
/* 645 */       String str = object.toString();
/* 646 */       if (!isKnownSetting(str) && dbSettings.containsKey(str)) {
/* 647 */         hashMap.put(str, this.prop.getProperty(str));
/*     */       }
/*     */     } 
/* 650 */     return DbSettings.getInstance(hashMap);
/*     */   }
/*     */   
/*     */   private static String remapURL(String paramString) {
/* 654 */     String str = SysProperties.URL_MAP;
/* 655 */     if (str != null && str.length() > 0) {
/*     */       
/*     */       try {
/* 658 */         SortedProperties sortedProperties = SortedProperties.loadProperties(str);
/* 659 */         String str1 = sortedProperties.getProperty(paramString);
/* 660 */         if (str1 == null) {
/* 661 */           sortedProperties.put(paramString, "");
/* 662 */           sortedProperties.store(str);
/*     */         } else {
/* 664 */           str1 = str1.trim();
/* 665 */           if (str1.length() > 0) {
/* 666 */             return str1;
/*     */           }
/*     */         } 
/* 669 */       } catch (IOException iOException) {
/* 670 */         throw DbException.convert(iOException);
/*     */       } 
/*     */     }
/* 673 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\ConnectionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */