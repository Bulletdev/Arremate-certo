/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
/*     */ import org.apache.poi.ss.formula.ptg.AttrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.FuncVarPtg;
/*     */ import org.apache.poi.ss.formula.ptg.OperationPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.RangePtg;
/*     */ import org.apache.poi.util.Removal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class OperandClassTransformer
/*     */ {
/*     */   private final FormulaType _formulaType;
/*     */   
/*     */   @Removal(version = "3.17")
/*     */   public OperandClassTransformer(int paramInt) {
/*  68 */     this(FormulaType.forInt(paramInt));
/*     */   }
/*     */   public OperandClassTransformer(FormulaType paramFormulaType) {
/*  71 */     this._formulaType = paramFormulaType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transformFormula(ParseNode paramParseNode) {
/*     */     byte b;
/*  80 */     switch (this._formulaType) {
/*     */       case CELL:
/*  82 */         b = 32;
/*     */         break;
/*     */       case ARRAY:
/*  85 */         b = 64;
/*     */         break;
/*     */       case NAMEDRANGE:
/*     */       case DATAVALIDATION_LIST:
/*  89 */         b = 0;
/*     */         break;
/*     */       default:
/*  92 */         throw new RuntimeException("Incomplete code - formula type (" + this._formulaType + ") not supported yet");
/*     */     } 
/*     */ 
/*     */     
/*  96 */     transformNode(paramParseNode, b, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void transformNode(ParseNode paramParseNode, byte paramByte, boolean paramBoolean) {
/*     */     OperationPtg operationPtg;
/* 106 */     Ptg ptg = paramParseNode.getToken();
/* 107 */     ParseNode[] arrayOfParseNode = paramParseNode.getChildren();
/* 108 */     boolean bool = isSimpleValueFunction(ptg);
/*     */     
/* 110 */     if (bool) {
/* 111 */       boolean bool1 = (paramByte == 64) ? true : false;
/* 112 */       for (byte b = 0; b < arrayOfParseNode.length; b++) {
/* 113 */         transformNode(arrayOfParseNode[b], paramByte, bool1);
/*     */       }
/* 115 */       setSimpleValueFuncClass((AbstractFunctionPtg)ptg, paramByte, paramBoolean);
/*     */       
/*     */       return;
/*     */     } 
/* 119 */     if (isSingleArgSum(ptg))
/*     */     {
/*     */       
/* 122 */       operationPtg = FuncVarPtg.SUM;
/*     */     }
/*     */ 
/*     */     
/* 126 */     if (operationPtg instanceof org.apache.poi.ss.formula.ptg.ValueOperatorPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.ControlPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.MemFuncPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.MemAreaPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.UnionPtg || operationPtg instanceof org.apache.poi.ss.formula.ptg.IntersectionPtg) {
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
/* 137 */       boolean bool1 = (paramByte == 0) ? true : paramByte;
/* 138 */       for (byte b = 0; b < arrayOfParseNode.length; b++) {
/* 139 */         transformNode(arrayOfParseNode[b], bool1, paramBoolean);
/*     */       }
/*     */       return;
/*     */     } 
/* 143 */     if (operationPtg instanceof AbstractFunctionPtg) {
/* 144 */       transformFunctionNode((AbstractFunctionPtg)operationPtg, arrayOfParseNode, paramByte, paramBoolean);
/*     */       return;
/*     */     } 
/* 147 */     if (arrayOfParseNode.length > 0) {
/* 148 */       if (operationPtg == RangePtg.instance) {
/*     */         return;
/*     */       }
/*     */       
/* 152 */       throw new IllegalStateException("Node should not have any children");
/*     */     } 
/*     */     
/* 155 */     if (operationPtg.isBaseToken()) {
/*     */       return;
/*     */     }
/*     */     
/* 159 */     operationPtg.setClass(transformClass(operationPtg.getPtgClass(), paramByte, paramBoolean));
/*     */   }
/*     */   
/*     */   private static boolean isSingleArgSum(Ptg paramPtg) {
/* 163 */     if (paramPtg instanceof AttrPtg) {
/* 164 */       AttrPtg attrPtg = (AttrPtg)paramPtg;
/* 165 */       return attrPtg.isSum();
/*     */     } 
/* 167 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isSimpleValueFunction(Ptg paramPtg) {
/* 171 */     if (paramPtg instanceof AbstractFunctionPtg) {
/* 172 */       AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg)paramPtg;
/* 173 */       if (abstractFunctionPtg.getDefaultOperandClass() != 32) {
/* 174 */         return false;
/*     */       }
/* 176 */       int i = abstractFunctionPtg.getNumberOfOperands();
/* 177 */       for (int j = i - 1; j >= 0; j--) {
/* 178 */         if (abstractFunctionPtg.getParameterClass(j) != 32) {
/* 179 */           return false;
/*     */         }
/*     */       } 
/* 182 */       return true;
/*     */     } 
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private byte transformClass(byte paramByte1, byte paramByte2, boolean paramBoolean) {
/* 189 */     switch (paramByte2) {
/*     */       case 32:
/* 191 */         if (!paramBoolean) {
/* 192 */           return 32;
/*     */         }
/*     */       
/*     */       case 64:
/* 196 */         return 64;
/*     */       case 0:
/* 198 */         if (!paramBoolean) {
/* 199 */           return paramByte1;
/*     */         }
/* 201 */         return 0;
/*     */     } 
/* 203 */     throw new IllegalStateException("Unexpected operand class (" + paramByte2 + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void transformFunctionNode(AbstractFunctionPtg paramAbstractFunctionPtg, ParseNode[] paramArrayOfParseNode, byte paramByte, boolean paramBoolean) {
/*     */     boolean bool;
/* 210 */     byte b = paramAbstractFunctionPtg.getDefaultOperandClass();
/*     */     
/* 212 */     if (paramBoolean) {
/* 213 */       switch (b) {
/*     */         case 0:
/* 215 */           if (paramByte == 0) {
/* 216 */             paramAbstractFunctionPtg.setClass((byte)0);
/*     */           } else {
/* 218 */             paramAbstractFunctionPtg.setClass((byte)64);
/*     */           } 
/* 220 */           bool = false;
/*     */           break;
/*     */         case 64:
/* 223 */           paramAbstractFunctionPtg.setClass((byte)64);
/* 224 */           bool = false;
/*     */           break;
/*     */         case 32:
/* 227 */           paramAbstractFunctionPtg.setClass((byte)64);
/* 228 */           bool = true;
/*     */           break;
/*     */         default:
/* 231 */           throw new IllegalStateException("Unexpected operand class (" + b + ")");
/*     */       } 
/*     */ 
/*     */     
/* 235 */     } else if (b == paramByte) {
/* 236 */       bool = false;
/*     */ 
/*     */ 
/*     */       
/* 240 */       paramAbstractFunctionPtg.setClass(b);
/*     */     } else {
/* 242 */       switch (paramByte) {
/*     */         
/*     */         case 32:
/* 245 */           paramAbstractFunctionPtg.setClass((byte)32);
/* 246 */           bool = false;
/*     */           break;
/*     */         case 64:
/* 249 */           switch (b) {
/*     */             case 0:
/* 251 */               paramAbstractFunctionPtg.setClass((byte)0);
/*     */               break;
/*     */             
/*     */             case 32:
/* 255 */               paramAbstractFunctionPtg.setClass((byte)64);
/*     */               break;
/*     */             default:
/* 258 */               throw new IllegalStateException("Unexpected operand class (" + b + ")");
/*     */           } 
/*     */           
/* 261 */           bool = (b == 32) ? true : false;
/*     */           break;
/*     */         case 0:
/* 264 */           switch (b) {
/*     */             case 64:
/* 266 */               paramAbstractFunctionPtg.setClass((byte)64);
/*     */               break;
/*     */             case 32:
/* 269 */               paramAbstractFunctionPtg.setClass((byte)32);
/*     */               break;
/*     */             default:
/* 272 */               throw new IllegalStateException("Unexpected operand class (" + b + ")");
/*     */           } 
/*     */           
/* 275 */           bool = false;
/*     */           break;
/*     */         default:
/* 278 */           throw new IllegalStateException("Unexpected operand class (" + paramByte + ")");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 285 */     for (byte b1 = 0; b1 < paramArrayOfParseNode.length; b1++) {
/* 286 */       ParseNode parseNode = paramArrayOfParseNode[b1];
/* 287 */       byte b2 = paramAbstractFunctionPtg.getParameterClass(b1);
/* 288 */       transformNode(parseNode, b2, bool);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setSimpleValueFuncClass(AbstractFunctionPtg paramAbstractFunctionPtg, byte paramByte, boolean paramBoolean) {
/* 295 */     if (paramBoolean || paramByte == 64) {
/* 296 */       paramAbstractFunctionPtg.setClass((byte)64);
/*     */     } else {
/* 298 */       paramAbstractFunctionPtg.setClass((byte)32);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\OperandClassTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */