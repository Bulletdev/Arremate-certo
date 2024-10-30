/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Stack;
/*     */ import org.apache.poi.ss.formula.ptg.AttrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.OperationPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ public class FormulaRenderer
/*     */ {
/*     */   public static String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook, Ptg[] paramArrayOfPtg) {
/*  47 */     if (paramArrayOfPtg == null || paramArrayOfPtg.length == 0) {
/*  48 */       throw new IllegalArgumentException("ptgs must not be null");
/*     */     }
/*  50 */     Stack<String> stack = new Stack();
/*     */     
/*  52 */     for (Ptg ptg : paramArrayOfPtg) {
/*     */       
/*  54 */       if (!(ptg instanceof org.apache.poi.ss.formula.ptg.MemAreaPtg) && !(ptg instanceof org.apache.poi.ss.formula.ptg.MemFuncPtg) && !(ptg instanceof org.apache.poi.ss.formula.ptg.MemErrPtg))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  60 */         if (ptg instanceof org.apache.poi.ss.formula.ptg.ParenthesisPtg) {
/*  61 */           String str1 = stack.pop();
/*  62 */           stack.push("(" + str1 + ")");
/*     */         
/*     */         }
/*  65 */         else if (ptg instanceof AttrPtg) {
/*  66 */           AttrPtg attrPtg = (AttrPtg)ptg;
/*  67 */           if (!attrPtg.isOptimizedIf() && !attrPtg.isOptimizedChoose() && !attrPtg.isSkip())
/*     */           {
/*     */             
/*  70 */             if (!attrPtg.isSpace())
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  77 */               if (!attrPtg.isSemiVolatile())
/*     */               {
/*     */ 
/*     */                 
/*  81 */                 if (attrPtg.isSum()) {
/*  82 */                   String[] arrayOfString = getOperands(stack, attrPtg.getNumberOfOperands());
/*  83 */                   stack.push(attrPtg.toFormulaString(arrayOfString));
/*     */                 } else {
/*     */                   
/*  86 */                   throw new RuntimeException("Unexpected tAttr: " + attrPtg.toString());
/*     */                 }  }  } 
/*     */           }
/*  89 */         } else if (ptg instanceof WorkbookDependentFormula) {
/*  90 */           WorkbookDependentFormula workbookDependentFormula = (WorkbookDependentFormula)ptg;
/*  91 */           stack.push(workbookDependentFormula.toFormulaString(paramFormulaRenderingWorkbook));
/*     */         
/*     */         }
/*  94 */         else if (!(ptg instanceof OperationPtg)) {
/*  95 */           stack.push(ptg.toFormulaString());
/*     */         }
/*     */         else {
/*     */           
/*  99 */           OperationPtg operationPtg = (OperationPtg)ptg;
/* 100 */           String[] arrayOfString = getOperands(stack, operationPtg.getNumberOfOperands());
/* 101 */           stack.push(operationPtg.toFormulaString(arrayOfString));
/*     */         }  } 
/* 103 */     }  if (stack.isEmpty())
/*     */     {
/*     */       
/* 106 */       throw new IllegalStateException("Stack underflow");
/*     */     }
/* 108 */     String str = stack.pop();
/* 109 */     if (!stack.isEmpty())
/*     */     {
/*     */       
/* 112 */       throw new IllegalStateException("too much stuff left on the stack");
/*     */     }
/* 114 */     return str;
/*     */   }
/*     */   
/*     */   private static String[] getOperands(Stack<String> paramStack, int paramInt) {
/* 118 */     String[] arrayOfString = new String[paramInt];
/*     */     
/* 120 */     for (int i = paramInt - 1; i >= 0; i--) {
/* 121 */       if (paramStack.isEmpty()) {
/* 122 */         String str = "Too few arguments supplied to operation. Expected (" + paramInt + ") operands but got (" + (paramInt - i - 1) + ")";
/*     */         
/* 124 */         throw new IllegalStateException(str);
/*     */       } 
/* 126 */       arrayOfString[i] = paramStack.pop();
/*     */     } 
/* 128 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */