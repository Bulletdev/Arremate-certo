/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.store.FileLister;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.store.fs.FileChannelInputStream;
/*     */ import org.h2.store.fs.FileChannelOutputStream;
/*     */ import org.h2.store.fs.FilePath;
/*     */ import org.h2.store.fs.FilePathEncrypt;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.Tool;
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
/*     */ public class ChangeFileEncryption
/*     */   extends Tool
/*     */ {
/*     */   private String directory;
/*     */   private String cipherType;
/*     */   private byte[] decrypt;
/*     */   private byte[] encrypt;
/*     */   private byte[] decryptKey;
/*     */   private byte[] encryptKey;
/*     */   
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  66 */     (new ChangeFileEncryption()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  71 */     String str1 = ".";
/*  72 */     String str2 = null;
/*  73 */     char[] arrayOfChar1 = null;
/*  74 */     char[] arrayOfChar2 = null;
/*  75 */     String str3 = null;
/*  76 */     boolean bool = false;
/*  77 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  78 */       String str = paramVarArgs[b];
/*  79 */       if (str.equals("-dir"))
/*  80 */       { str1 = paramVarArgs[++b]; }
/*  81 */       else if (str.equals("-cipher"))
/*  82 */       { str2 = paramVarArgs[++b]; }
/*  83 */       else if (str.equals("-db"))
/*  84 */       { str3 = paramVarArgs[++b]; }
/*  85 */       else if (str.equals("-decrypt"))
/*  86 */       { arrayOfChar1 = paramVarArgs[++b].toCharArray(); }
/*  87 */       else if (str.equals("-encrypt"))
/*  88 */       { arrayOfChar2 = paramVarArgs[++b].toCharArray(); }
/*  89 */       else if (str.equals("-quiet"))
/*  90 */       { bool = true; }
/*  91 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  92 */           showUsage();
/*     */           return;
/*     */         } 
/*  95 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*  98 */     if ((arrayOfChar2 == null && arrayOfChar1 == null) || str2 == null) {
/*  99 */       showUsage();
/* 100 */       throw new SQLException("Encryption or decryption password not set, or cipher not set");
/*     */     } 
/*     */     
/*     */     try {
/* 104 */       process(str1, str3, str2, arrayOfChar1, arrayOfChar2, bool);
/* 105 */     } catch (Exception exception) {
/* 106 */       throw DbException.toSQLException(exception);
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
/*     */   private static byte[] getFileEncryptionKey(char[] paramArrayOfchar) {
/* 118 */     if (paramArrayOfchar == null) {
/* 119 */       return null;
/*     */     }
/* 121 */     return SHA256.getKeyPasswordHash("file", paramArrayOfchar);
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
/*     */   public static void execute(String paramString1, String paramString2, String paramString3, char[] paramArrayOfchar1, char[] paramArrayOfchar2, boolean paramBoolean) throws SQLException {
/*     */     try {
/* 140 */       (new ChangeFileEncryption()).process(paramString1, paramString2, paramString3, paramArrayOfchar1, paramArrayOfchar2, paramBoolean);
/*     */     }
/* 142 */     catch (Exception exception) {
/* 143 */       throw DbException.toSQLException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void process(String paramString1, String paramString2, String paramString3, char[] paramArrayOfchar1, char[] paramArrayOfchar2, boolean paramBoolean) throws SQLException {
/* 150 */     paramString1 = FileLister.getDir(paramString1);
/* 151 */     ChangeFileEncryption changeFileEncryption = new ChangeFileEncryption();
/* 152 */     if (paramArrayOfchar2 != null) {
/* 153 */       for (char c : paramArrayOfchar2) {
/* 154 */         if (c == ' ') {
/* 155 */           throw new SQLException("The file password may not contain spaces");
/*     */         }
/*     */       } 
/* 158 */       changeFileEncryption.encryptKey = FilePathEncrypt.getPasswordBytes(paramArrayOfchar2);
/* 159 */       changeFileEncryption.encrypt = getFileEncryptionKey(paramArrayOfchar2);
/*     */     } 
/* 161 */     if (paramArrayOfchar1 != null) {
/* 162 */       changeFileEncryption.decryptKey = FilePathEncrypt.getPasswordBytes(paramArrayOfchar1);
/* 163 */       changeFileEncryption.decrypt = getFileEncryptionKey(paramArrayOfchar1);
/*     */     } 
/* 165 */     changeFileEncryption.out = this.out;
/* 166 */     changeFileEncryption.directory = paramString1;
/* 167 */     changeFileEncryption.cipherType = paramString3;
/*     */     
/* 169 */     ArrayList arrayList = FileLister.getDatabaseFiles(paramString1, paramString2, true);
/* 170 */     FileLister.tryUnlockDatabase(arrayList, "encryption");
/* 171 */     arrayList = FileLister.getDatabaseFiles(paramString1, paramString2, false);
/* 172 */     if (arrayList.size() == 0 && !paramBoolean) {
/* 173 */       printNoDatabaseFilesFound(paramString1, paramString2);
/*     */     }
/*     */ 
/*     */     
/* 177 */     for (String str1 : arrayList) {
/* 178 */       String str2 = paramString1 + "/temp.db";
/* 179 */       FileUtils.delete(str2);
/* 180 */       FileUtils.move(str1, str2);
/* 181 */       FileUtils.move(str2, str1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 186 */     for (String str : arrayList) {
/*     */       
/* 188 */       if (!FileUtils.isDirectory(str))
/* 189 */         changeFileEncryption.process(str, paramBoolean); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void process(String paramString, boolean paramBoolean) {
/*     */     FileStore fileStore;
/* 195 */     if (paramString.endsWith(".mv.db")) {
/*     */       try {
/* 197 */         copy(paramString, paramBoolean);
/* 198 */       } catch (IOException iOException) {
/* 199 */         throw DbException.convertIOException(iOException, "Error encrypting / decrypting file " + paramString);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 205 */     if (this.decrypt == null) {
/* 206 */       fileStore = FileStore.open(null, paramString, "r");
/*     */     } else {
/* 208 */       fileStore = FileStore.open(null, paramString, "r", this.cipherType, this.decrypt);
/*     */     } 
/*     */     try {
/* 211 */       fileStore.init();
/* 212 */       copy(paramString, fileStore, this.encrypt, paramBoolean);
/*     */     } finally {
/* 214 */       fileStore.closeSilently();
/*     */     } 
/*     */   }
/*     */   private void copy(String paramString, boolean paramBoolean) throws IOException {
/*     */     FilePathEncrypt.FileEncrypt fileEncrypt1, fileEncrypt2;
/* 219 */     if (FileUtils.isDirectory(paramString)) {
/*     */       return;
/*     */     }
/* 222 */     FileChannel fileChannel1 = FilePath.get(paramString).open("r");
/* 223 */     FileChannel fileChannel2 = null;
/* 224 */     String str = this.directory + "/temp.db";
/*     */     try {
/* 226 */       if (this.decryptKey != null) {
/* 227 */         fileEncrypt1 = new FilePathEncrypt.FileEncrypt(paramString, this.decryptKey, fileChannel1);
/*     */       }
/* 229 */       FileChannelInputStream fileChannelInputStream = new FileChannelInputStream((FileChannel)fileEncrypt1, true);
/* 230 */       FileUtils.delete(str);
/* 231 */       fileChannel2 = FilePath.get(str).open("rw");
/* 232 */       if (this.encryptKey != null) {
/* 233 */         fileEncrypt2 = new FilePathEncrypt.FileEncrypt(str, this.encryptKey, fileChannel2);
/*     */       }
/* 235 */       FileChannelOutputStream fileChannelOutputStream = new FileChannelOutputStream((FileChannel)fileEncrypt2, true);
/* 236 */       byte[] arrayOfByte = new byte[4096];
/* 237 */       long l1 = fileEncrypt1.size();
/* 238 */       long l2 = l1;
/* 239 */       long l3 = System.currentTimeMillis();
/* 240 */       while (l1 > 0L) {
/* 241 */         if (!paramBoolean && System.currentTimeMillis() - l3 > 1000L) {
/* 242 */           this.out.println(paramString + ": " + (100L - 100L * l1 / l2) + "%");
/* 243 */           l3 = System.currentTimeMillis();
/*     */         } 
/* 245 */         int i = (int)Math.min(arrayOfByte.length, l1);
/* 246 */         i = fileChannelInputStream.read(arrayOfByte, 0, i);
/* 247 */         fileChannelOutputStream.write(arrayOfByte, 0, i);
/* 248 */         l1 -= i;
/*     */       } 
/* 250 */       fileChannelInputStream.close();
/* 251 */       fileChannelOutputStream.close();
/*     */     } finally {
/* 253 */       fileEncrypt1.close();
/* 254 */       if (fileEncrypt2 != null) {
/* 255 */         fileEncrypt2.close();
/*     */       }
/*     */     } 
/* 258 */     FileUtils.delete(paramString);
/* 259 */     FileUtils.move(str, paramString);
/*     */   }
/*     */   private void copy(String paramString, FileStore paramFileStore, byte[] paramArrayOfbyte, boolean paramBoolean) {
/*     */     FileStore fileStore;
/* 263 */     if (FileUtils.isDirectory(paramString)) {
/*     */       return;
/*     */     }
/* 266 */     String str = this.directory + "/temp.db";
/* 267 */     FileUtils.delete(str);
/*     */     
/* 269 */     if (paramArrayOfbyte == null) {
/* 270 */       fileStore = FileStore.open(null, str, "rw");
/*     */     } else {
/* 272 */       fileStore = FileStore.open(null, str, "rw", this.cipherType, paramArrayOfbyte);
/*     */     } 
/* 274 */     fileStore.init();
/* 275 */     byte[] arrayOfByte = new byte[4096];
/* 276 */     long l1 = paramFileStore.length() - 48L;
/* 277 */     long l2 = l1;
/* 278 */     paramFileStore.seek(48L);
/* 279 */     fileStore.seek(48L);
/* 280 */     long l3 = System.currentTimeMillis();
/* 281 */     while (l1 > 0L) {
/* 282 */       if (!paramBoolean && System.currentTimeMillis() - l3 > 1000L) {
/* 283 */         this.out.println(paramString + ": " + (100L - 100L * l1 / l2) + "%");
/* 284 */         l3 = System.currentTimeMillis();
/*     */       } 
/* 286 */       int i = (int)Math.min(arrayOfByte.length, l1);
/* 287 */       paramFileStore.readFully(arrayOfByte, 0, i);
/* 288 */       fileStore.write(arrayOfByte, 0, i);
/* 289 */       l1 -= i;
/*     */     } 
/* 291 */     paramFileStore.close();
/* 292 */     fileStore.close();
/* 293 */     FileUtils.delete(paramString);
/* 294 */     FileUtils.move(str, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\ChangeFileEncryption.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */