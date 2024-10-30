/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.h2.api.JavaObjectSerializer;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.SHA256;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.store.FileStoreInputStream;
/*     */ import org.h2.store.FileStoreOutputStream;
/*     */ import org.h2.store.LobStorageBackend;
/*     */ import org.h2.store.LobStorageInterface;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.tools.CompressTool;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.SmallLRUCache;
/*     */ import org.h2.util.TempFileDeleter;
/*     */ import org.h2.value.CompareMode;
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
/*     */ abstract class ScriptBase
/*     */   extends Prepared
/*     */   implements DataHandler
/*     */ {
/*     */   private static final String SCRIPT_SQL = "script.sql";
/*     */   protected OutputStream out;
/*     */   protected InputStream in;
/*     */   private Expression fileNameExpr;
/*     */   private Expression password;
/*     */   private String fileName;
/*     */   private String cipher;
/*     */   private FileStore store;
/*     */   private String compressionAlgorithm;
/*     */   
/*     */   ScriptBase(Session paramSession) {
/*  69 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setCipher(String paramString) {
/*  73 */     this.cipher = paramString;
/*     */   }
/*     */   
/*     */   private boolean isEncrypted() {
/*  77 */     return (this.cipher != null);
/*     */   }
/*     */   
/*     */   public void setPassword(Expression paramExpression) {
/*  81 */     this.password = paramExpression;
/*     */   }
/*     */   
/*     */   public void setFileNameExpr(Expression paramExpression) {
/*  85 */     this.fileNameExpr = paramExpression;
/*     */   }
/*     */   
/*     */   protected String getFileName() {
/*  89 */     if (this.fileNameExpr != null && this.fileName == null) {
/*  90 */       this.fileName = this.fileNameExpr.optimize(this.session).getValue(this.session).getString();
/*  91 */       if (this.fileName == null || this.fileName.trim().length() == 0) {
/*  92 */         this.fileName = "script.sql";
/*     */       }
/*  94 */       this.fileName = SysProperties.getScriptDirectory() + this.fileName;
/*     */     } 
/*  96 */     return this.fileName;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void deleteStore() {
/* 108 */     String str = getFileName();
/* 109 */     if (str != null) {
/* 110 */       FileUtils.delete(str);
/*     */     }
/*     */   }
/*     */   
/*     */   private void initStore() {
/* 115 */     Database database = this.session.getDatabase();
/* 116 */     byte[] arrayOfByte = null;
/* 117 */     if (this.cipher != null && this.password != null) {
/* 118 */       char[] arrayOfChar = this.password.optimize(this.session).getValue(this.session).getString().toCharArray();
/*     */       
/* 120 */       arrayOfByte = SHA256.getKeyPasswordHash("script", arrayOfChar);
/*     */     } 
/* 122 */     String str = getFileName();
/* 123 */     this.store = FileStore.open((DataHandler)database, str, "rw", this.cipher, arrayOfByte);
/* 124 */     this.store.setCheckedWriting(false);
/* 125 */     this.store.init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void openOutput() {
/* 132 */     String str = getFileName();
/* 133 */     if (str == null) {
/*     */       return;
/*     */     }
/* 136 */     if (isEncrypted()) {
/* 137 */       initStore();
/* 138 */       this.out = (OutputStream)new FileStoreOutputStream(this.store, this, this.compressionAlgorithm);
/*     */       
/* 140 */       this.out = new BufferedOutputStream(this.out, 131072);
/*     */     } else {
/*     */       OutputStream outputStream;
/*     */       try {
/* 144 */         outputStream = FileUtils.newOutputStream(str, false);
/* 145 */       } catch (IOException iOException) {
/* 146 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/* 148 */       this.out = new BufferedOutputStream(outputStream, 4096);
/* 149 */       this.out = CompressTool.wrapOutputStream(this.out, this.compressionAlgorithm, "script.sql");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void openInput() {
/* 157 */     String str = getFileName();
/* 158 */     if (str == null) {
/*     */       return;
/*     */     }
/* 161 */     if (isEncrypted()) {
/* 162 */       initStore();
/* 163 */       this.in = (InputStream)new FileStoreInputStream(this.store, this, (this.compressionAlgorithm != null), false);
/*     */     } else {
/*     */       InputStream inputStream;
/*     */       try {
/* 167 */         inputStream = FileUtils.newInputStream(str);
/* 168 */       } catch (IOException iOException) {
/* 169 */         throw DbException.convertIOException(iOException, str);
/*     */       } 
/* 171 */       this.in = new BufferedInputStream(inputStream, 4096);
/* 172 */       this.in = CompressTool.wrapInputStream(this.in, this.compressionAlgorithm, "script.sql");
/* 173 */       if (this.in == null) {
/* 174 */         throw DbException.get(90124, "script.sql in " + str);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void closeIO() {
/* 183 */     IOUtils.closeSilently(this.out);
/* 184 */     this.out = null;
/* 185 */     IOUtils.closeSilently(this.in);
/* 186 */     this.in = null;
/* 187 */     if (this.store != null) {
/* 188 */       this.store.closeSilently();
/* 189 */       this.store = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRecompile() {
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDatabasePath() {
/* 200 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileStore openFile(String paramString1, String paramString2, boolean paramBoolean) {
/* 205 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkPowerOff() {
/* 210 */     this.session.getDatabase().checkPowerOff();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkWritingAllowed() {
/* 215 */     this.session.getDatabase().checkWritingAllowed();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxLengthInplaceLob() {
/* 220 */     return this.session.getDatabase().getMaxLengthInplaceLob();
/*     */   }
/*     */ 
/*     */   
/*     */   public TempFileDeleter getTempFileDeleter() {
/* 225 */     return this.session.getDatabase().getTempFileDeleter();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLobCompressionAlgorithm(int paramInt) {
/* 230 */     return this.session.getDatabase().getLobCompressionAlgorithm(paramInt);
/*     */   }
/*     */   
/*     */   public void setCompressionAlgorithm(String paramString) {
/* 234 */     this.compressionAlgorithm = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getLobSyncObject() {
/* 239 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public SmallLRUCache<String, String[]> getLobFileListCache() {
/* 244 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public LobStorageBackend getLobStorage() {
/* 249 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int readLob(long paramLong1, byte[] paramArrayOfbyte1, long paramLong2, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/* 255 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public JavaObjectSerializer getJavaObjectSerializer() {
/* 260 */     return this.session.getDataHandler().getJavaObjectSerializer();
/*     */   }
/*     */ 
/*     */   
/*     */   public CompareMode getCompareMode() {
/* 265 */     return this.session.getDataHandler().getCompareMode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\ScriptBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */