/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.Mode;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueString;
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
/*     */ public class Operation
/*     */   extends Expression
/*     */ {
/*     */   public static final int CONCAT = 0;
/*     */   public static final int PLUS = 1;
/*     */   public static final int MINUS = 2;
/*     */   public static final int MULTIPLY = 3;
/*     */   public static final int DIVIDE = 4;
/*     */   public static final int NEGATE = 5;
/*     */   public static final int MODULUS = 6;
/*     */   private int opType;
/*     */   private Expression left;
/*     */   private Expression right;
/*     */   private int dataType;
/*     */   private boolean convertRight = true;
/*     */   
/*     */   public Operation(int paramInt, Expression paramExpression1, Expression paramExpression2) {
/*  67 */     this.opType = paramInt;
/*  68 */     this.left = paramExpression1;
/*  69 */     this.right = paramExpression2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*     */     String str;
/*  75 */     if (this.opType == 5) {
/*     */ 
/*     */       
/*  78 */       str = "- " + this.left.getSQL();
/*     */     }
/*     */     else {
/*     */       
/*  82 */       str = this.left.getSQL() + " " + getOperationToken() + " " + this.right.getSQL();
/*     */     } 
/*  84 */     return "(" + str + ")";
/*     */   }
/*     */   
/*     */   private String getOperationToken() {
/*  88 */     switch (this.opType) {
/*     */       case 5:
/*  90 */         return "-";
/*     */       case 0:
/*  92 */         return "||";
/*     */       case 1:
/*  94 */         return "+";
/*     */       case 2:
/*  96 */         return "-";
/*     */       case 3:
/*  98 */         return "*";
/*     */       case 4:
/* 100 */         return "/";
/*     */       case 6:
/* 102 */         return "%";
/*     */     } 
/* 104 */     throw DbException.throwInternalError("opType=" + this.opType);
/*     */   } public Value getValue(Session paramSession) {
/*     */     Value value2;
/*     */     Mode mode;
/*     */     String str1, str2;
/*     */     StringBuilder stringBuilder;
/* 110 */     Value value1 = this.left.getValue(paramSession).convertTo(this.dataType);
/*     */     
/* 112 */     if (this.right == null) {
/* 113 */       value2 = null;
/*     */     } else {
/* 115 */       value2 = this.right.getValue(paramSession);
/* 116 */       if (this.convertRight) {
/* 117 */         value2 = value2.convertTo(this.dataType);
/*     */       }
/*     */     } 
/* 120 */     switch (this.opType) {
/*     */       case 5:
/* 122 */         return (value1 == ValueNull.INSTANCE) ? value1 : value1.negate();
/*     */       case 0:
/* 124 */         mode = paramSession.getDatabase().getMode();
/* 125 */         if (value1 == ValueNull.INSTANCE) {
/* 126 */           if (mode.nullConcatIsNull) {
/* 127 */             return (Value)ValueNull.INSTANCE;
/*     */           }
/* 129 */           return value2;
/* 130 */         }  if (value2 == ValueNull.INSTANCE) {
/* 131 */           if (mode.nullConcatIsNull) {
/* 132 */             return (Value)ValueNull.INSTANCE;
/*     */           }
/* 134 */           return value1;
/*     */         } 
/* 136 */         str1 = value1.getString(); str2 = value2.getString();
/* 137 */         stringBuilder = new StringBuilder(str1.length() + str2.length());
/* 138 */         stringBuilder.append(str1).append(str2);
/* 139 */         return ValueString.get(stringBuilder.toString());
/*     */       
/*     */       case 1:
/* 142 */         if (value1 == ValueNull.INSTANCE || value2 == ValueNull.INSTANCE) {
/* 143 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 145 */         return value1.add(value2);
/*     */       case 2:
/* 147 */         if (value1 == ValueNull.INSTANCE || value2 == ValueNull.INSTANCE) {
/* 148 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 150 */         return value1.subtract(value2);
/*     */       case 3:
/* 152 */         if (value1 == ValueNull.INSTANCE || value2 == ValueNull.INSTANCE) {
/* 153 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 155 */         return value1.multiply(value2);
/*     */       case 4:
/* 157 */         if (value1 == ValueNull.INSTANCE || value2 == ValueNull.INSTANCE) {
/* 158 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 160 */         return value1.divide(value2);
/*     */       case 6:
/* 162 */         if (value1 == ValueNull.INSTANCE || value2 == ValueNull.INSTANCE) {
/* 163 */           return (Value)ValueNull.INSTANCE;
/*     */         }
/* 165 */         return value1.modulus(value2);
/*     */     } 
/* 167 */     throw DbException.throwInternalError("type=" + this.opType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 173 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 174 */     if (this.right != null) {
/* 175 */       this.right.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*     */     int i, j;
/* 181 */     this.left = this.left.optimize(paramSession);
/* 182 */     switch (this.opType) {
/*     */       case 5:
/* 184 */         this.dataType = this.left.getType();
/* 185 */         if (this.dataType == -1) {
/* 186 */           this.dataType = 6;
/*     */         }
/*     */         break;
/*     */       case 0:
/* 190 */         this.right = this.right.optimize(paramSession);
/* 191 */         this.dataType = 13;
/* 192 */         if (this.left.isConstant() && this.right.isConstant()) {
/* 193 */           return ValueExpression.get(getValue(paramSession));
/*     */         }
/*     */         break;
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 6:
/* 201 */         this.right = this.right.optimize(paramSession);
/* 202 */         i = this.left.getType();
/* 203 */         j = this.right.getType();
/* 204 */         if ((i == 0 && j == 0) || (i == -1 && j == -1)) {
/*     */ 
/*     */ 
/*     */           
/* 208 */           if (this.opType == 1 && (paramSession.getDatabase().getMode()).allowPlusForStringConcat) {
/*     */             
/* 210 */             this.dataType = 13;
/* 211 */             this.opType = 0; break;
/*     */           } 
/* 213 */           this.dataType = 6; break;
/*     */         } 
/* 215 */         if (i == 10 || i == 11 || i == 9 || j == 10 || j == 11 || j == 9) {
/*     */ 
/*     */           
/* 218 */           if (this.opType == 1) {
/* 219 */             if (j != Value.getHigherOrder(i, j)) {
/*     */               
/* 221 */               swap();
/* 222 */               int k = i;
/* 223 */               i = j;
/* 224 */               j = k;
/*     */             } 
/* 226 */             if (i == 4) {
/*     */               
/* 228 */               Function function = Function.getFunction(paramSession.getDatabase(), "DATEADD");
/* 229 */               function.setParameter(0, ValueExpression.get(ValueString.get("DAY")));
/* 230 */               function.setParameter(1, this.left);
/* 231 */               function.setParameter(2, this.right);
/* 232 */               function.doneWithParameters();
/* 233 */               return function.optimize(paramSession);
/* 234 */             }  if (i == 6 || i == 8 || i == 7) {
/*     */               
/* 236 */               Function function = Function.getFunction(paramSession.getDatabase(), "DATEADD");
/* 237 */               function.setParameter(0, ValueExpression.get(ValueString.get("SECOND")));
/* 238 */               this.left = new Operation(3, ValueExpression.get((Value)ValueInt.get(86400)), this.left);
/*     */               
/* 240 */               function.setParameter(1, this.left);
/* 241 */               function.setParameter(2, this.right);
/* 242 */               function.doneWithParameters();
/* 243 */               return function.optimize(paramSession);
/* 244 */             }  if (i == 9 && j == 9) {
/* 245 */               this.dataType = 9;
/* 246 */               return this;
/* 247 */             }  if (i == 9) {
/* 248 */               this.dataType = 11;
/* 249 */               return this;
/*     */             } 
/* 251 */           } else if (this.opType == 2) {
/* 252 */             if ((i == 10 || i == 11) && j == 4) {
/*     */               
/* 254 */               Function function = Function.getFunction(paramSession.getDatabase(), "DATEADD");
/* 255 */               function.setParameter(0, ValueExpression.get(ValueString.get("DAY")));
/* 256 */               this.right = new Operation(5, this.right, null);
/* 257 */               this.right = this.right.optimize(paramSession);
/* 258 */               function.setParameter(1, this.right);
/* 259 */               function.setParameter(2, this.left);
/* 260 */               function.doneWithParameters();
/* 261 */               return function.optimize(paramSession);
/* 262 */             }  if ((i == 10 || i == 11) && (j == 6 || j == 8 || j == 7)) {
/*     */ 
/*     */               
/* 265 */               Function function = Function.getFunction(paramSession.getDatabase(), "DATEADD");
/* 266 */               function.setParameter(0, ValueExpression.get(ValueString.get("SECOND")));
/* 267 */               this.right = new Operation(3, ValueExpression.get((Value)ValueInt.get(86400)), this.right);
/*     */               
/* 269 */               this.right = new Operation(5, this.right, null);
/* 270 */               this.right = this.right.optimize(paramSession);
/* 271 */               function.setParameter(1, this.right);
/* 272 */               function.setParameter(2, this.left);
/* 273 */               function.doneWithParameters();
/* 274 */               return function.optimize(paramSession);
/* 275 */             }  if (i == 10 || i == 11) {
/* 276 */               if (j == 9) {
/* 277 */                 this.dataType = 11;
/* 278 */                 return this;
/* 279 */               }  if (j == 10 || j == 11) {
/*     */                 
/* 281 */                 Function function = Function.getFunction(paramSession.getDatabase(), "DATEDIFF");
/* 282 */                 function.setParameter(0, ValueExpression.get(ValueString.get("DAY")));
/* 283 */                 function.setParameter(1, this.right);
/* 284 */                 function.setParameter(2, this.left);
/* 285 */                 function.doneWithParameters();
/* 286 */                 return function.optimize(paramSession);
/*     */               } 
/* 288 */             } else if (i == 9 && j == 9) {
/* 289 */               this.dataType = 9;
/* 290 */               return this;
/*     */             } 
/* 292 */           } else if (this.opType == 3) {
/* 293 */             if (i == 9) {
/* 294 */               this.dataType = 9;
/* 295 */               this.convertRight = false;
/* 296 */               return this;
/* 297 */             }  if (j == 9) {
/* 298 */               swap();
/* 299 */               this.dataType = 9;
/* 300 */               this.convertRight = false;
/* 301 */               return this;
/*     */             } 
/* 303 */           } else if (this.opType == 4 && 
/* 304 */             i == 9) {
/* 305 */             this.dataType = 9;
/* 306 */             this.convertRight = false;
/* 307 */             return this;
/*     */           } 
/*     */           
/* 310 */           throw DbException.getUnsupportedException((DataType.getDataType(i)).name + " " + getOperationToken() + " " + (DataType.getDataType(j)).name);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 315 */         this.dataType = Value.getHigherOrder(i, j);
/* 316 */         if (DataType.isStringType(this.dataType) && (paramSession.getDatabase().getMode()).allowPlusForStringConcat)
/*     */         {
/* 318 */           this.opType = 0;
/*     */         }
/*     */         break;
/*     */       
/*     */       default:
/* 323 */         DbException.throwInternalError("type=" + this.opType); break;
/*     */     } 
/* 325 */     if (this.left.isConstant() && (this.right == null || this.right.isConstant())) {
/* 326 */       return ValueExpression.get(getValue(paramSession));
/*     */     }
/* 328 */     return this;
/*     */   }
/*     */   
/*     */   private void swap() {
/* 332 */     Expression expression = this.left;
/* 333 */     this.left = this.right;
/* 334 */     this.right = expression;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 339 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 340 */     if (this.right != null) {
/* 341 */       this.right.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 347 */     return this.dataType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/* 352 */     if (this.right != null) {
/* 353 */       switch (this.opType) {
/*     */         case 0:
/* 355 */           return this.left.getPrecision() + this.right.getPrecision();
/*     */       } 
/* 357 */       return Math.max(this.left.getPrecision(), this.right.getPrecision());
/*     */     } 
/*     */     
/* 360 */     return this.left.getPrecision();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/* 365 */     if (this.right != null) {
/* 366 */       switch (this.opType) {
/*     */         case 0:
/* 368 */           return MathUtils.convertLongToInt(this.left.getDisplaySize() + this.right.getDisplaySize());
/*     */       } 
/*     */       
/* 371 */       return Math.max(this.left.getDisplaySize(), this.right.getDisplaySize());
/*     */     } 
/*     */     
/* 374 */     return this.left.getDisplaySize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/* 379 */     if (this.right != null) {
/* 380 */       return Math.max(this.left.getScale(), this.right.getScale());
/*     */     }
/* 382 */     return this.left.getScale();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 387 */     this.left.updateAggregate(paramSession);
/* 388 */     if (this.right != null) {
/* 389 */       this.right.updateAggregate(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 395 */     return (this.left.isEverything(paramExpressionVisitor) && (this.right == null || this.right.isEverything(paramExpressionVisitor)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 401 */     return this.left.getCost() + 1 + ((this.right == null) ? 0 : this.right.getCost());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Operation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */