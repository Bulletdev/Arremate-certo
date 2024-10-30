/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Set;
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
/*     */ public class ThrowableProxy
/*     */   implements IThrowableProxy
/*     */ {
/*  29 */   static final StackTraceElementProxy[] EMPTY_STEP = new StackTraceElementProxy[0];
/*     */   
/*     */   private Throwable throwable;
/*     */   
/*     */   private String className;
/*     */   
/*     */   private String message;
/*     */   StackTraceElementProxy[] stackTraceElementProxyArray;
/*     */   int commonFrames;
/*     */   private ThrowableProxy cause;
/*  39 */   private static final ThrowableProxy[] NO_SUPPRESSED = new ThrowableProxy[0];
/*  40 */   private ThrowableProxy[] suppressed = NO_SUPPRESSED;
/*     */   
/*     */   private transient PackagingDataCalculator packagingDataCalculator;
/*     */   
/*     */   private boolean calculatedPackageData = false;
/*     */   
/*     */   private boolean circular;
/*     */   
/*     */   private static final Method GET_SUPPRESSED_METHOD;
/*     */ 
/*     */   
/*     */   static {
/*  52 */     Method method = null;
/*     */     try {
/*  54 */       method = Throwable.class.getMethod("getSuppressed", new Class[0]);
/*  55 */     } catch (NoSuchMethodException noSuchMethodException) {}
/*     */ 
/*     */     
/*  58 */     GET_SUPPRESSED_METHOD = method;
/*     */   }
/*     */ 
/*     */   
/*     */   public ThrowableProxy(Throwable paramThrowable) {
/*  63 */     this(paramThrowable, Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>()));
/*     */   }
/*     */ 
/*     */   
/*     */   private ThrowableProxy(Throwable paramThrowable, boolean paramBoolean) {
/*  68 */     this.throwable = paramThrowable;
/*  69 */     this.className = paramThrowable.getClass().getName();
/*  70 */     this.message = paramThrowable.getMessage();
/*  71 */     this.stackTraceElementProxyArray = EMPTY_STEP;
/*  72 */     this.circular = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ThrowableProxy(Throwable paramThrowable, Set<Throwable> paramSet) {
/*  77 */     this.throwable = paramThrowable;
/*  78 */     this.className = paramThrowable.getClass().getName();
/*  79 */     this.message = paramThrowable.getMessage();
/*  80 */     this.stackTraceElementProxyArray = ThrowableProxyUtil.steArrayToStepArray(paramThrowable.getStackTrace());
/*  81 */     this.circular = false;
/*     */     
/*  83 */     paramSet.add(paramThrowable);
/*     */     
/*  85 */     Throwable throwable = paramThrowable.getCause();
/*  86 */     if (throwable != null) {
/*  87 */       if (paramSet.contains(throwable)) {
/*  88 */         this.cause = new ThrowableProxy(throwable, true);
/*     */       } else {
/*  90 */         this.cause = new ThrowableProxy(throwable, paramSet);
/*  91 */         this.cause.commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(throwable.getStackTrace(), this.stackTraceElementProxyArray);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  96 */     if (GET_SUPPRESSED_METHOD != null) {
/*     */       
/*  98 */       Throwable[] arrayOfThrowable = extractSupressedThrowables(paramThrowable);
/*     */       
/* 100 */       if (OptionHelper.isNotEmtpy((Object[])arrayOfThrowable)) {
/* 101 */         ArrayList<ThrowableProxy> arrayList = new ArrayList(arrayOfThrowable.length);
/* 102 */         for (Throwable throwable1 : arrayOfThrowable) {
/* 103 */           if (paramSet.contains(throwable1)) {
/* 104 */             ThrowableProxy throwableProxy = new ThrowableProxy(throwable1, true);
/* 105 */             arrayList.add(throwableProxy);
/*     */           } else {
/* 107 */             ThrowableProxy throwableProxy = new ThrowableProxy(throwable1, paramSet);
/* 108 */             throwableProxy.commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(throwable1.getStackTrace(), this.stackTraceElementProxyArray);
/*     */             
/* 110 */             arrayList.add(throwableProxy);
/*     */           } 
/*     */         } 
/* 113 */         this.suppressed = arrayList.<ThrowableProxy>toArray(new ThrowableProxy[arrayList.size()]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Throwable[] extractSupressedThrowables(Throwable paramThrowable) {
/*     */     try {
/* 120 */       Object object = GET_SUPPRESSED_METHOD.invoke(paramThrowable, new Object[0]);
/* 121 */       if (object instanceof Throwable[]) {
/* 122 */         return (Throwable[])object;
/*     */       }
/*     */       
/* 125 */       return null;
/*     */     }
/* 127 */     catch (IllegalAccessException illegalAccessException) {
/*     */     
/* 129 */     } catch (IllegalArgumentException illegalArgumentException) {
/*     */     
/* 131 */     } catch (InvocationTargetException invocationTargetException) {}
/*     */ 
/*     */ 
/*     */     
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Throwable getThrowable() {
/* 140 */     return this.throwable;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 144 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClassName() {
/* 153 */     return this.className;
/*     */   }
/*     */   
/*     */   public StackTraceElementProxy[] getStackTraceElementProxyArray() {
/* 157 */     return this.stackTraceElementProxyArray;
/*     */   }
/*     */   
/*     */   public boolean isCyclic() {
/* 161 */     return this.circular;
/*     */   }
/*     */   
/*     */   public int getCommonFrames() {
/* 165 */     return this.commonFrames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IThrowableProxy getCause() {
/* 174 */     return this.cause;
/*     */   }
/*     */   
/*     */   public IThrowableProxy[] getSuppressed() {
/* 178 */     return (IThrowableProxy[])this.suppressed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PackagingDataCalculator getPackagingDataCalculator() {
/* 185 */     if (this.throwable != null && this.packagingDataCalculator == null) {
/* 186 */       this.packagingDataCalculator = new PackagingDataCalculator();
/*     */     }
/* 188 */     return this.packagingDataCalculator;
/*     */   }
/*     */   
/*     */   public void calculatePackagingData() {
/* 192 */     if (this.calculatedPackageData) {
/*     */       return;
/*     */     }
/* 195 */     PackagingDataCalculator packagingDataCalculator = getPackagingDataCalculator();
/* 196 */     if (packagingDataCalculator != null) {
/* 197 */       this.calculatedPackageData = true;
/* 198 */       packagingDataCalculator.calculate(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void fullDump() {
/* 203 */     StringBuilder stringBuilder = new StringBuilder();
/* 204 */     for (StackTraceElementProxy stackTraceElementProxy : this.stackTraceElementProxyArray) {
/* 205 */       String str = stackTraceElementProxy.toString();
/* 206 */       stringBuilder.append('\t').append(str);
/* 207 */       ThrowableProxyUtil.subjoinPackagingData(stringBuilder, stackTraceElementProxy);
/* 208 */       stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/* 210 */     System.out.println(stringBuilder.toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\ThrowableProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */