/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
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
/*     */ public class CommonsLogger
/*     */   extends POILogger
/*     */ {
/*  33 */   private static LogFactory _creator = LogFactory.getFactory();
/*  34 */   private Log log = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(String paramString) {
/*  39 */     this.log = _creator.getInstance(paramString);
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
/*     */   public void log(int paramInt, Object paramObject) {
/*  51 */     if (paramInt == 9) {
/*     */       
/*  53 */       if (this.log.isFatalEnabled())
/*     */       {
/*  55 */         this.log.fatal(paramObject);
/*     */       }
/*     */     }
/*  58 */     else if (paramInt == 7) {
/*     */       
/*  60 */       if (this.log.isErrorEnabled())
/*     */       {
/*  62 */         this.log.error(paramObject);
/*     */       }
/*     */     }
/*  65 */     else if (paramInt == 5) {
/*     */       
/*  67 */       if (this.log.isWarnEnabled())
/*     */       {
/*  69 */         this.log.warn(paramObject);
/*     */       }
/*     */     }
/*  72 */     else if (paramInt == 3) {
/*     */       
/*  74 */       if (this.log.isInfoEnabled())
/*     */       {
/*  76 */         this.log.info(paramObject);
/*     */       }
/*     */     }
/*  79 */     else if (paramInt == 1) {
/*     */       
/*  81 */       if (this.log.isDebugEnabled())
/*     */       {
/*  83 */         this.log.debug(paramObject);
/*     */       
/*     */       }
/*     */     
/*     */     }
/*  88 */     else if (this.log.isTraceEnabled()) {
/*     */       
/*  90 */       this.log.trace(paramObject);
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
/*     */ 
/*     */   
/*     */   public void log(int paramInt, Object paramObject, Throwable paramThrowable) {
/* 106 */     if (paramInt == 9) {
/*     */       
/* 108 */       if (this.log.isFatalEnabled())
/*     */       {
/* 110 */         if (paramObject != null) {
/* 111 */           this.log.fatal(paramObject, paramThrowable);
/*     */         } else {
/* 113 */           this.log.fatal(paramThrowable);
/*     */         } 
/*     */       }
/* 116 */     } else if (paramInt == 7) {
/*     */       
/* 118 */       if (this.log.isErrorEnabled())
/*     */       {
/* 120 */         if (paramObject != null) {
/* 121 */           this.log.error(paramObject, paramThrowable);
/*     */         } else {
/* 123 */           this.log.error(paramThrowable);
/*     */         } 
/*     */       }
/* 126 */     } else if (paramInt == 5) {
/*     */       
/* 128 */       if (this.log.isWarnEnabled())
/*     */       {
/* 130 */         if (paramObject != null) {
/* 131 */           this.log.warn(paramObject, paramThrowable);
/*     */         } else {
/* 133 */           this.log.warn(paramThrowable);
/*     */         } 
/*     */       }
/* 136 */     } else if (paramInt == 3) {
/*     */       
/* 138 */       if (this.log.isInfoEnabled())
/*     */       {
/* 140 */         if (paramObject != null) {
/* 141 */           this.log.info(paramObject, paramThrowable);
/*     */         } else {
/* 143 */           this.log.info(paramThrowable);
/*     */         } 
/*     */       }
/* 146 */     } else if (paramInt == 1) {
/*     */       
/* 148 */       if (this.log.isDebugEnabled())
/*     */       {
/* 150 */         if (paramObject != null) {
/* 151 */           this.log.debug(paramObject, paramThrowable);
/*     */         } else {
/* 153 */           this.log.debug(paramThrowable);
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 158 */     else if (this.log.isTraceEnabled()) {
/*     */       
/* 160 */       if (paramObject != null) {
/* 161 */         this.log.trace(paramObject, paramThrowable);
/*     */       } else {
/* 163 */         this.log.trace(paramThrowable);
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
/*     */ 
/*     */   
/*     */   public boolean check(int paramInt) {
/* 177 */     if (paramInt == 9) {
/*     */       
/* 179 */       if (this.log.isFatalEnabled())
/*     */       {
/* 181 */         return true;
/*     */       }
/*     */     }
/* 184 */     else if (paramInt == 7) {
/*     */       
/* 186 */       if (this.log.isErrorEnabled())
/*     */       {
/* 188 */         return true;
/*     */       }
/*     */     }
/* 191 */     else if (paramInt == 5) {
/*     */       
/* 193 */       if (this.log.isWarnEnabled())
/*     */       {
/* 195 */         return true;
/*     */       }
/*     */     }
/* 198 */     else if (paramInt == 3) {
/*     */       
/* 200 */       if (this.log.isInfoEnabled())
/*     */       {
/* 202 */         return true;
/*     */       }
/*     */     }
/* 205 */     else if (paramInt == 1) {
/*     */       
/* 207 */       if (this.log.isDebugEnabled())
/*     */       {
/* 209 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 213 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\CommonsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */