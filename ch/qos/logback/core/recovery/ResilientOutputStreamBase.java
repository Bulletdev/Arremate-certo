/*     */ package ch.qos.logback.core.recovery;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.InfoStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public abstract class ResilientOutputStreamBase
/*     */   extends OutputStream
/*     */ {
/*     */   static final int STATUS_COUNT_LIMIT = 8;
/*  29 */   private int noContextWarning = 0;
/*  30 */   private int statusCount = 0;
/*     */   
/*     */   private Context context;
/*     */   
/*     */   private RecoveryCoordinator recoveryCoordinator;
/*     */   
/*     */   protected OutputStream os;
/*     */   protected boolean presumedClean = true;
/*     */   
/*     */   private boolean isPresumedInError() {
/*  40 */     return (this.recoveryCoordinator != null && !this.presumedClean);
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  44 */     if (isPresumedInError()) {
/*  45 */       if (!this.recoveryCoordinator.isTooSoon()) {
/*  46 */         attemptRecovery();
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/*  52 */       this.os.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  53 */       postSuccessfulWrite();
/*  54 */     } catch (IOException iOException) {
/*  55 */       postIOFailure(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) {
/*  61 */     if (isPresumedInError()) {
/*  62 */       if (!this.recoveryCoordinator.isTooSoon()) {
/*  63 */         attemptRecovery();
/*     */       }
/*     */       return;
/*     */     } 
/*     */     try {
/*  68 */       this.os.write(paramInt);
/*  69 */       postSuccessfulWrite();
/*  70 */     } catch (IOException iOException) {
/*  71 */       postIOFailure(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {
/*  77 */     if (this.os != null) {
/*     */       try {
/*  79 */         this.os.flush();
/*  80 */         postSuccessfulWrite();
/*  81 */       } catch (IOException iOException) {
/*  82 */         postIOFailure(iOException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   abstract String getDescription();
/*     */   
/*     */   abstract OutputStream openNewOutputStream() throws IOException;
/*     */   
/*     */   private void postSuccessfulWrite() {
/*  92 */     if (this.recoveryCoordinator != null) {
/*  93 */       this.recoveryCoordinator = null;
/*  94 */       this.statusCount = 0;
/*  95 */       addStatus((Status)new InfoStatus("Recovered from IO failure on " + getDescription(), this));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void postIOFailure(IOException paramIOException) {
/* 100 */     addStatusIfCountNotOverLimit((Status)new ErrorStatus("IO failure while writing to " + getDescription(), this, paramIOException));
/* 101 */     this.presumedClean = false;
/* 102 */     if (this.recoveryCoordinator == null) {
/* 103 */       this.recoveryCoordinator = new RecoveryCoordinator();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 109 */     if (this.os != null) {
/* 110 */       this.os.close();
/*     */     }
/*     */   }
/*     */   
/*     */   void attemptRecovery() {
/*     */     try {
/* 116 */       close();
/* 117 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 120 */     addStatusIfCountNotOverLimit((Status)new InfoStatus("Attempting to recover from IO failure on " + getDescription(), this));
/*     */ 
/*     */     
/*     */     try {
/* 124 */       this.os = openNewOutputStream();
/* 125 */       this.presumedClean = true;
/* 126 */     } catch (IOException iOException) {
/* 127 */       addStatusIfCountNotOverLimit((Status)new ErrorStatus("Failed to open " + getDescription(), this, iOException));
/*     */     } 
/*     */   }
/*     */   
/*     */   void addStatusIfCountNotOverLimit(Status paramStatus) {
/* 132 */     this.statusCount++;
/* 133 */     if (this.statusCount < 8) {
/* 134 */       addStatus(paramStatus);
/*     */     }
/*     */     
/* 137 */     if (this.statusCount == 8) {
/* 138 */       addStatus(paramStatus);
/* 139 */       addStatus((Status)new InfoStatus("Will supress future messages regarding " + getDescription(), this));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addStatus(Status paramStatus) {
/* 144 */     if (this.context == null) {
/* 145 */       if (this.noContextWarning++ == 0) {
/* 146 */         System.out.println("LOGBACK: No context given for " + this);
/*     */       }
/*     */       return;
/*     */     } 
/* 150 */     StatusManager statusManager = this.context.getStatusManager();
/* 151 */     if (statusManager != null) {
/* 152 */       statusManager.add(paramStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   public Context getContext() {
/* 157 */     return this.context;
/*     */   }
/*     */   
/*     */   public void setContext(Context paramContext) {
/* 161 */     this.context = paramContext;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\recovery\ResilientOutputStreamBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */