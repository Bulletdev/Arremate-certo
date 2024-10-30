/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ @Internal
/*     */ public final class CollaboratingWorkbooksEnvironment
/*     */ {
/*     */   public static final class WorkbookNotFoundException
/*     */     extends Exception
/*     */   {
/*     */     private static final long serialVersionUID = 8787784539811167941L;
/*     */     
/*     */     WorkbookNotFoundException(String param1String) {
/*  43 */       super(param1String);
/*     */     }
/*     */   }
/*     */   
/*  47 */   public static final CollaboratingWorkbooksEnvironment EMPTY = new CollaboratingWorkbooksEnvironment();
/*     */   
/*     */   private final Map<String, WorkbookEvaluator> _evaluatorsByName;
/*     */   private final WorkbookEvaluator[] _evaluators;
/*     */   private boolean _unhooked;
/*     */   
/*     */   private CollaboratingWorkbooksEnvironment() {
/*  54 */     this._evaluatorsByName = Collections.emptyMap();
/*  55 */     this._evaluators = new WorkbookEvaluator[0];
/*     */   }
/*     */   
/*     */   public static void setup(String[] paramArrayOfString, WorkbookEvaluator[] paramArrayOfWorkbookEvaluator) {
/*  59 */     int i = paramArrayOfString.length;
/*  60 */     if (paramArrayOfWorkbookEvaluator.length != i) {
/*  61 */       throw new IllegalArgumentException("Number of workbook names is " + i + " but number of evaluators is " + paramArrayOfWorkbookEvaluator.length);
/*     */     }
/*     */     
/*  64 */     if (i < 1) {
/*  65 */       throw new IllegalArgumentException("Must provide at least one collaborating worbook");
/*     */     }
/*  67 */     new CollaboratingWorkbooksEnvironment(paramArrayOfString, paramArrayOfWorkbookEvaluator, i);
/*     */   }
/*     */   public static void setup(Map<String, WorkbookEvaluator> paramMap) {
/*  70 */     if (paramMap.size() < 1) {
/*  71 */       throw new IllegalArgumentException("Must provide at least one collaborating worbook");
/*     */     }
/*  73 */     WorkbookEvaluator[] arrayOfWorkbookEvaluator = (WorkbookEvaluator[])paramMap.values().toArray((Object[])new WorkbookEvaluator[paramMap.size()]);
/*     */     
/*  75 */     new CollaboratingWorkbooksEnvironment(paramMap, arrayOfWorkbookEvaluator);
/*     */   }
/*     */   public static void setupFormulaEvaluator(Map<String, FormulaEvaluator> paramMap) {
/*  78 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramMap.size());
/*  79 */     for (Map.Entry<String, FormulaEvaluator> entry : paramMap.entrySet()) {
/*  80 */       String str = (String)entry.getKey();
/*  81 */       FormulaEvaluator formulaEvaluator = (FormulaEvaluator)entry.getValue();
/*  82 */       if (formulaEvaluator instanceof WorkbookEvaluatorProvider) {
/*  83 */         hashMap.put(str, ((WorkbookEvaluatorProvider)formulaEvaluator)._getWorkbookEvaluator()); continue;
/*     */       } 
/*  85 */       throw new IllegalArgumentException("Formula Evaluator " + formulaEvaluator + " provides no WorkbookEvaluator access");
/*     */     } 
/*     */ 
/*     */     
/*  89 */     setup((Map)hashMap);
/*     */   }
/*     */   
/*     */   private CollaboratingWorkbooksEnvironment(String[] paramArrayOfString, WorkbookEvaluator[] paramArrayOfWorkbookEvaluator, int paramInt) {
/*  93 */     this(toUniqueMap(paramArrayOfString, paramArrayOfWorkbookEvaluator, paramInt), paramArrayOfWorkbookEvaluator);
/*     */   }
/*     */   private static Map<String, WorkbookEvaluator> toUniqueMap(String[] paramArrayOfString, WorkbookEvaluator[] paramArrayOfWorkbookEvaluator, int paramInt) {
/*  96 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramInt * 3 / 2);
/*  97 */     for (byte b = 0; b < paramInt; b++) {
/*  98 */       String str = paramArrayOfString[b];
/*  99 */       WorkbookEvaluator workbookEvaluator = paramArrayOfWorkbookEvaluator[b];
/* 100 */       if (hashMap.containsKey(str)) {
/* 101 */         throw new IllegalArgumentException("Duplicate workbook name '" + str + "'");
/*     */       }
/* 103 */       hashMap.put(str, workbookEvaluator);
/*     */     } 
/* 105 */     return (Map)hashMap;
/*     */   }
/*     */   private CollaboratingWorkbooksEnvironment(Map<String, WorkbookEvaluator> paramMap, WorkbookEvaluator[] paramArrayOfWorkbookEvaluator) {
/* 108 */     IdentityHashMap<Object, Object> identityHashMap = new IdentityHashMap<Object, Object>(paramArrayOfWorkbookEvaluator.length);
/* 109 */     for (Map.Entry<String, WorkbookEvaluator> entry : paramMap.entrySet()) {
/* 110 */       String str = (String)identityHashMap.put(entry.getValue(), entry.getKey());
/* 111 */       if (str != null) {
/* 112 */         String str1 = "Attempted to register same workbook under names '" + str + "' and '" + (String)entry.getKey() + "'";
/*     */         
/* 114 */         throw new IllegalArgumentException(str1);
/*     */       } 
/*     */     } 
/* 117 */     unhookOldEnvironments(paramArrayOfWorkbookEvaluator);
/* 118 */     hookNewEnvironment(paramArrayOfWorkbookEvaluator, this);
/* 119 */     this._unhooked = false;
/* 120 */     this._evaluators = (WorkbookEvaluator[])paramArrayOfWorkbookEvaluator.clone();
/* 121 */     this._evaluatorsByName = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void hookNewEnvironment(WorkbookEvaluator[] paramArrayOfWorkbookEvaluator, CollaboratingWorkbooksEnvironment paramCollaboratingWorkbooksEnvironment) {
/* 127 */     int i = paramArrayOfWorkbookEvaluator.length;
/* 128 */     IEvaluationListener iEvaluationListener = paramArrayOfWorkbookEvaluator[0].getEvaluationListener();
/*     */     
/* 130 */     for (byte b1 = 0; b1 < i; b1++) {
/* 131 */       if (iEvaluationListener != paramArrayOfWorkbookEvaluator[b1].getEvaluationListener())
/*     */       {
/* 133 */         throw new RuntimeException("Workbook evaluators must all have the same evaluation listener");
/*     */       }
/*     */     } 
/* 136 */     EvaluationCache evaluationCache = new EvaluationCache(iEvaluationListener);
/*     */     
/* 138 */     for (byte b2 = 0; b2 < i; b2++) {
/* 139 */       paramArrayOfWorkbookEvaluator[b2].attachToEnvironment(paramCollaboratingWorkbooksEnvironment, evaluationCache, b2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void unhookOldEnvironments(WorkbookEvaluator[] paramArrayOfWorkbookEvaluator) {
/* 147 */     HashSet<CollaboratingWorkbooksEnvironment> hashSet = new HashSet();
/* 148 */     for (byte b1 = 0; b1 < paramArrayOfWorkbookEvaluator.length; b1++) {
/* 149 */       hashSet.add(paramArrayOfWorkbookEvaluator[b1].getEnvironment());
/*     */     }
/* 151 */     CollaboratingWorkbooksEnvironment[] arrayOfCollaboratingWorkbooksEnvironment = new CollaboratingWorkbooksEnvironment[hashSet.size()];
/* 152 */     hashSet.toArray(arrayOfCollaboratingWorkbooksEnvironment);
/* 153 */     for (byte b2 = 0; b2 < arrayOfCollaboratingWorkbooksEnvironment.length; b2++) {
/* 154 */       arrayOfCollaboratingWorkbooksEnvironment[b2].unhook();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void unhook() {
/* 162 */     if (this._evaluators.length < 1) {
/*     */       return;
/*     */     }
/*     */     
/* 166 */     for (byte b = 0; b < this._evaluators.length; b++) {
/* 167 */       this._evaluators[b].detachFromEnvironment();
/*     */     }
/* 169 */     this._unhooked = true;
/*     */   }
/*     */   
/*     */   public WorkbookEvaluator getWorkbookEvaluator(String paramString) throws WorkbookNotFoundException {
/* 173 */     if (this._unhooked) {
/* 174 */       throw new IllegalStateException("This environment has been unhooked");
/*     */     }
/* 176 */     WorkbookEvaluator workbookEvaluator = this._evaluatorsByName.get(paramString);
/* 177 */     if (workbookEvaluator == null) {
/* 178 */       StringBuffer stringBuffer = new StringBuffer(256);
/* 179 */       stringBuffer.append("Could not resolve external workbook name '").append(paramString).append("'.");
/* 180 */       if (this._evaluators.length < 1) {
/* 181 */         stringBuffer.append(" Workbook environment has not been set up.");
/*     */       } else {
/* 183 */         stringBuffer.append(" The following workbook names are valid: (");
/* 184 */         Iterator<String> iterator = this._evaluatorsByName.keySet().iterator();
/* 185 */         byte b = 0;
/* 186 */         while (iterator.hasNext()) {
/* 187 */           if (b++ > 0) {
/* 188 */             stringBuffer.append(", ");
/*     */           }
/* 190 */           stringBuffer.append("'").append(iterator.next()).append("'");
/*     */         } 
/* 192 */         stringBuffer.append(")");
/*     */       } 
/* 194 */       throw new WorkbookNotFoundException(stringBuffer.toString());
/*     */     } 
/* 196 */     return workbookEvaluator;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\CollaboratingWorkbooksEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */