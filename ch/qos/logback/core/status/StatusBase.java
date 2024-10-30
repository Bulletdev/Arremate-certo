/*     */ package ch.qos.logback.core.status;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public abstract class StatusBase
/*     */   implements Status
/*     */ {
/*  22 */   private static final List<Status> EMPTY_LIST = new ArrayList<Status>(0);
/*     */   
/*     */   int level;
/*     */   final String message;
/*     */   final Object origin;
/*     */   List<Status> childrenList;
/*     */   Throwable throwable;
/*     */   long date;
/*     */   
/*     */   StatusBase(int paramInt, String paramString, Object paramObject) {
/*  32 */     this(paramInt, paramString, paramObject, null);
/*     */   }
/*     */   
/*     */   StatusBase(int paramInt, String paramString, Object paramObject, Throwable paramThrowable) {
/*  36 */     this.level = paramInt;
/*  37 */     this.message = paramString;
/*  38 */     this.origin = paramObject;
/*  39 */     this.throwable = paramThrowable;
/*  40 */     this.date = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public synchronized void add(Status paramStatus) {
/*  44 */     if (paramStatus == null) {
/*  45 */       throw new NullPointerException("Null values are not valid Status.");
/*     */     }
/*  47 */     if (this.childrenList == null) {
/*  48 */       this.childrenList = new ArrayList<Status>();
/*     */     }
/*  50 */     this.childrenList.add(paramStatus);
/*     */   }
/*     */   
/*     */   public synchronized boolean hasChildren() {
/*  54 */     return (this.childrenList != null && this.childrenList.size() > 0);
/*     */   }
/*     */   
/*     */   public synchronized Iterator<Status> iterator() {
/*  58 */     if (this.childrenList != null) {
/*  59 */       return this.childrenList.iterator();
/*     */     }
/*  61 */     return EMPTY_LIST.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean remove(Status paramStatus) {
/*  66 */     if (this.childrenList == null) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     return this.childrenList.remove(paramStatus);
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  74 */     return this.level;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getEffectiveLevel() {
/*  82 */     int i = this.level;
/*     */ 
/*     */     
/*  85 */     Iterator<Status> iterator = iterator();
/*     */     
/*  87 */     while (iterator.hasNext()) {
/*  88 */       Status status = iterator.next();
/*  89 */       int j = status.getEffectiveLevel();
/*  90 */       if (j > i) {
/*  91 */         i = j;
/*     */       }
/*     */     } 
/*  94 */     return i;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  98 */     return this.message;
/*     */   }
/*     */   
/*     */   public Object getOrigin() {
/* 102 */     return this.origin;
/*     */   }
/*     */   
/*     */   public Throwable getThrowable() {
/* 106 */     return this.throwable;
/*     */   }
/*     */   
/*     */   public Long getDate() {
/* 110 */     return Long.valueOf(this.date);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder stringBuilder = new StringBuilder();
/* 118 */     switch (getEffectiveLevel()) {
/*     */       case 0:
/* 120 */         stringBuilder.append("INFO");
/*     */         break;
/*     */       case 1:
/* 123 */         stringBuilder.append("WARN");
/*     */         break;
/*     */       case 2:
/* 126 */         stringBuilder.append("ERROR");
/*     */         break;
/*     */     } 
/* 129 */     if (this.origin != null) {
/* 130 */       stringBuilder.append(" in ");
/* 131 */       stringBuilder.append(this.origin);
/* 132 */       stringBuilder.append(" -");
/*     */     } 
/*     */     
/* 135 */     stringBuilder.append(" ");
/* 136 */     stringBuilder.append(this.message);
/*     */     
/* 138 */     if (this.throwable != null) {
/* 139 */       stringBuilder.append(" ");
/* 140 */       stringBuilder.append(this.throwable);
/*     */     } 
/*     */     
/* 143 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 148 */     byte b = 31;
/* 149 */     int i = 1;
/* 150 */     i = 31 * i + this.level;
/* 151 */     i = 31 * i + ((this.message == null) ? 0 : this.message.hashCode());
/* 152 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 157 */     if (this == paramObject)
/* 158 */       return true; 
/* 159 */     if (paramObject == null)
/* 160 */       return false; 
/* 161 */     if (getClass() != paramObject.getClass())
/* 162 */       return false; 
/* 163 */     StatusBase statusBase = (StatusBase)paramObject;
/* 164 */     if (this.level != statusBase.level)
/* 165 */       return false; 
/* 166 */     if (this.message == null) {
/* 167 */       if (statusBase.message != null)
/* 168 */         return false; 
/* 169 */     } else if (!this.message.equals(statusBase.message)) {
/* 170 */       return false;
/* 171 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\StatusBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */