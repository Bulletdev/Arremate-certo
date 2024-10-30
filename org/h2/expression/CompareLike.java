/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.regex.PatternSyntaxException;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexCondition;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueBoolean;
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
/*     */ public class CompareLike
/*     */   extends Condition
/*     */ {
/*     */   private static final int MATCH = 0;
/*     */   private static final int ONE = 1;
/*     */   private static final int ANY = 2;
/*     */   private final CompareMode compareMode;
/*     */   private final String defaultEscape;
/*     */   private Expression left;
/*     */   private Expression right;
/*     */   private Expression escape;
/*     */   private boolean isInit;
/*     */   private char[] patternChars;
/*     */   private String patternString;
/*     */   private int[] patternTypes;
/*     */   private int patternLength;
/*     */   private final boolean regexp;
/*     */   private Pattern patternRegexp;
/*     */   private boolean ignoreCase;
/*     */   private boolean fastCompare;
/*     */   private boolean invalidPattern;
/*     */   private boolean shortcutToStartsWith;
/*     */   
/*     */   public CompareLike(Database paramDatabase, Expression paramExpression1, Expression paramExpression2, Expression paramExpression3, boolean paramBoolean) {
/*  55 */     this(paramDatabase.getCompareMode(), (paramDatabase.getSettings()).defaultEscape, paramExpression1, paramExpression2, paramExpression3, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CompareLike(CompareMode paramCompareMode, String paramString, Expression paramExpression1, Expression paramExpression2, Expression paramExpression3, boolean paramBoolean) {
/*  61 */     this.compareMode = paramCompareMode;
/*  62 */     this.defaultEscape = paramString;
/*  63 */     this.regexp = paramBoolean;
/*  64 */     this.left = paramExpression1;
/*  65 */     this.right = paramExpression2;
/*  66 */     this.escape = paramExpression3;
/*     */   }
/*     */   
/*     */   private static Character getEscapeChar(String paramString) {
/*  70 */     return (paramString == null || paramString.length() == 0) ? null : Character.valueOf(paramString.charAt(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*     */     String str;
/*  76 */     if (this.regexp) {
/*  77 */       str = this.left.getSQL() + " REGEXP " + this.right.getSQL();
/*     */     } else {
/*  79 */       str = this.left.getSQL() + " LIKE " + this.right.getSQL();
/*  80 */       if (this.escape != null) {
/*  81 */         str = str + " ESCAPE " + this.escape.getSQL();
/*     */       }
/*     */     } 
/*  84 */     return "(" + str + ")";
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  89 */     this.left = this.left.optimize(paramSession);
/*  90 */     this.right = this.right.optimize(paramSession);
/*  91 */     if (this.left.getType() == 14) {
/*  92 */       this.ignoreCase = true;
/*     */     }
/*  94 */     if (this.left.isValueSet()) {
/*  95 */       Value value = this.left.getValue(paramSession);
/*  96 */       if (value == ValueNull.INSTANCE)
/*     */       {
/*  98 */         return ValueExpression.getNull();
/*     */       }
/*     */     } 
/* 101 */     if (this.escape != null) {
/* 102 */       this.escape = this.escape.optimize(paramSession);
/*     */     }
/* 104 */     if (this.right.isValueSet() && (this.escape == null || this.escape.isValueSet())) {
/* 105 */       if (this.left.isValueSet()) {
/* 106 */         return ValueExpression.get(getValue(paramSession));
/*     */       }
/* 108 */       Value value1 = this.right.getValue(paramSession);
/* 109 */       if (value1 == ValueNull.INSTANCE)
/*     */       {
/* 111 */         return ValueExpression.getNull();
/*     */       }
/* 113 */       Value value2 = (this.escape == null) ? null : this.escape.getValue(paramSession);
/* 114 */       if (value2 == ValueNull.INSTANCE) {
/* 115 */         return ValueExpression.getNull();
/*     */       }
/* 117 */       String str = value1.getString();
/* 118 */       initPattern(str, getEscapeChar(value2));
/* 119 */       if (this.invalidPattern) {
/* 120 */         return ValueExpression.getNull();
/*     */       }
/* 122 */       if ("%".equals(str))
/*     */       {
/* 124 */         return (new Comparison(paramSession, 7, this.left, null)).optimize(paramSession);
/*     */       }
/*     */       
/* 127 */       if (isFullMatch()) {
/*     */         
/* 129 */         Value value = ValueString.get(this.patternString);
/* 130 */         ValueExpression valueExpression = ValueExpression.get(value);
/* 131 */         return (new Comparison(paramSession, 0, this.left, valueExpression)).optimize(paramSession);
/*     */       } 
/*     */       
/* 134 */       this.isInit = true;
/*     */     } 
/* 136 */     return this;
/*     */   }
/*     */   private Character getEscapeChar(Value paramValue) {
/*     */     Character character;
/* 140 */     if (paramValue == null) {
/* 141 */       return getEscapeChar(this.defaultEscape);
/*     */     }
/* 143 */     String str = paramValue.getString();
/*     */     
/* 145 */     if (str == null)
/* 146 */     { character = getEscapeChar(this.defaultEscape); }
/* 147 */     else if (str.length() == 0)
/* 148 */     { character = null; }
/* 149 */     else { if (str.length() > 1) {
/* 150 */         throw DbException.get(22025, str);
/*     */       }
/* 152 */       character = Character.valueOf(str.charAt(0)); }
/*     */     
/* 154 */     return character;
/*     */   }
/*     */ 
/*     */   
/*     */   public void createIndexConditions(Session paramSession, TableFilter paramTableFilter) {
/* 159 */     if (this.regexp) {
/*     */       return;
/*     */     }
/* 162 */     if (!(this.left instanceof ExpressionColumn)) {
/*     */       return;
/*     */     }
/* 165 */     ExpressionColumn expressionColumn = (ExpressionColumn)this.left;
/* 166 */     if (paramTableFilter != expressionColumn.getTableFilter()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     if (!this.right.isEverything(ExpressionVisitor.INDEPENDENT_VISITOR)) {
/*     */       return;
/*     */     }
/* 177 */     if (this.escape != null && !this.escape.isEverything(ExpressionVisitor.INDEPENDENT_VISITOR)) {
/*     */       return;
/*     */     }
/*     */     
/* 181 */     String str1 = this.right.getValue(paramSession).getString();
/* 182 */     Value value = (this.escape == null) ? null : this.escape.getValue(paramSession);
/* 183 */     if (value == ValueNull.INSTANCE)
/*     */     {
/* 185 */       DbException.throwInternalError();
/*     */     }
/* 187 */     initPattern(str1, getEscapeChar(value));
/* 188 */     if (this.invalidPattern) {
/*     */       return;
/*     */     }
/* 191 */     if (this.patternLength <= 0 || this.patternTypes[0] != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 195 */     int i = expressionColumn.getColumn().getType();
/* 196 */     if (i != 13 && i != 14 && i != 21) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     byte b = 0;
/* 204 */     StringBuilder stringBuilder = new StringBuilder();
/* 205 */     while (b < this.patternLength && this.patternTypes[b] == 0) {
/* 206 */       stringBuilder.append(this.patternChars[b++]);
/*     */     }
/* 208 */     String str2 = stringBuilder.toString();
/* 209 */     if (b == this.patternLength) {
/* 210 */       paramTableFilter.addIndexCondition(IndexCondition.get(0, expressionColumn, ValueExpression.get(ValueString.get(str2))));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 216 */     else if (str2.length() > 0) {
/* 217 */       paramTableFilter.addIndexCondition(IndexCondition.get(1, expressionColumn, ValueExpression.get(ValueString.get(str2))));
/*     */ 
/*     */       
/* 220 */       char c = str2.charAt(str2.length() - 1);
/*     */ 
/*     */       
/* 223 */       for (byte b1 = 1; b1 < 'ߐ'; b1++) {
/* 224 */         String str = str2.substring(0, str2.length() - 1) + (char)(c + b1);
/* 225 */         if (this.compareMode.compareString(str2, str, this.ignoreCase) == -1) {
/* 226 */           paramTableFilter.addIndexCondition(IndexCondition.get(4, expressionColumn, ValueExpression.get(ValueString.get(str))));
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*     */     boolean bool;
/* 238 */     Value value = this.left.getValue(paramSession);
/* 239 */     if (value == ValueNull.INSTANCE) {
/* 240 */       return value;
/*     */     }
/* 242 */     if (!this.isInit) {
/* 243 */       Value value1 = this.right.getValue(paramSession);
/* 244 */       if (value1 == ValueNull.INSTANCE) {
/* 245 */         return value1;
/*     */       }
/* 247 */       String str1 = value1.getString();
/* 248 */       Value value2 = (this.escape == null) ? null : this.escape.getValue(paramSession);
/* 249 */       if (value2 == ValueNull.INSTANCE) {
/* 250 */         return (Value)ValueNull.INSTANCE;
/*     */       }
/* 252 */       initPattern(str1, getEscapeChar(value2));
/*     */     } 
/* 254 */     if (this.invalidPattern) {
/* 255 */       return (Value)ValueNull.INSTANCE;
/*     */     }
/* 257 */     String str = value.getString();
/*     */     
/* 259 */     if (this.regexp) {
/* 260 */       bool = this.patternRegexp.matcher(str).find();
/* 261 */     } else if (this.shortcutToStartsWith) {
/* 262 */       bool = str.regionMatches(this.ignoreCase, 0, this.patternString, 0, this.patternLength - 1);
/*     */     } else {
/* 264 */       bool = compareAt(str, 0, 0, str.length(), this.patternChars, this.patternTypes);
/*     */     } 
/* 266 */     return (Value)ValueBoolean.get(bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compareAt(String paramString, int paramInt1, int paramInt2, int paramInt3, char[] paramArrayOfchar, int[] paramArrayOfint) {
/* 271 */     for (; paramInt1 < this.patternLength; paramInt1++) {
/* 272 */       switch (paramArrayOfint[paramInt1]) {
/*     */         case 0:
/* 274 */           if (paramInt2 >= paramInt3 || !compare(paramArrayOfchar, paramString, paramInt1, paramInt2++)) {
/* 275 */             return false;
/*     */           }
/*     */           break;
/*     */         case 1:
/* 279 */           if (paramInt2++ >= paramInt3) {
/* 280 */             return false;
/*     */           }
/*     */           break;
/*     */         case 2:
/* 284 */           if (++paramInt1 >= this.patternLength) {
/* 285 */             return true;
/*     */           }
/* 287 */           while (paramInt2 < paramInt3) {
/* 288 */             if (compare(paramArrayOfchar, paramString, paramInt1, paramInt2) && compareAt(paramString, paramInt1, paramInt2, paramInt3, paramArrayOfchar, paramArrayOfint))
/*     */             {
/* 290 */               return true;
/*     */             }
/* 292 */             paramInt2++;
/*     */           } 
/* 294 */           return false;
/*     */         default:
/* 296 */           DbException.throwInternalError(); break;
/*     */       } 
/*     */     } 
/* 299 */     return (paramInt2 == paramInt3);
/*     */   }
/*     */   
/*     */   private boolean compare(char[] paramArrayOfchar, String paramString, int paramInt1, int paramInt2) {
/* 303 */     return (paramArrayOfchar[paramInt1] == paramString.charAt(paramInt2) || (!this.fastCompare && this.compareMode.equalsChars(this.patternString, paramInt1, paramString, paramInt2, this.ignoreCase)));
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
/*     */   public boolean test(String paramString1, String paramString2, char paramChar) {
/* 317 */     initPattern(paramString1, Character.valueOf(paramChar));
/* 318 */     if (this.invalidPattern) {
/* 319 */       return false;
/*     */     }
/* 321 */     return compareAt(paramString2, 0, 0, paramString2.length(), this.patternChars, this.patternTypes);
/*     */   }
/*     */   
/*     */   private void initPattern(String paramString, Character paramCharacter) {
/* 325 */     if (this.compareMode.getName().equals("OFF") && !this.ignoreCase) {
/* 326 */       this.fastCompare = true;
/*     */     }
/* 328 */     if (this.regexp) {
/* 329 */       this.patternString = paramString;
/*     */       try {
/* 331 */         if (this.ignoreCase) {
/* 332 */           this.patternRegexp = Pattern.compile(paramString, 2);
/*     */         } else {
/* 334 */           this.patternRegexp = Pattern.compile(paramString);
/*     */         } 
/* 336 */       } catch (PatternSyntaxException patternSyntaxException) {
/* 337 */         throw DbException.get(22025, patternSyntaxException, new String[] { paramString });
/*     */       } 
/*     */       return;
/*     */     } 
/* 341 */     this.patternLength = 0;
/* 342 */     if (paramString == null) {
/* 343 */       this.patternTypes = null;
/* 344 */       this.patternChars = null;
/*     */       return;
/*     */     } 
/* 347 */     int i = paramString.length();
/* 348 */     this.patternChars = new char[i];
/* 349 */     this.patternTypes = new int[i];
/* 350 */     boolean bool = false; byte b;
/* 351 */     for (b = 0; b < i; b++) {
/* 352 */       boolean bool1; char c = paramString.charAt(b);
/*     */       
/* 354 */       if (paramCharacter != null && paramCharacter.charValue() == c) {
/* 355 */         if (b >= i - 1) {
/* 356 */           this.invalidPattern = true;
/*     */           return;
/*     */         } 
/* 359 */         c = paramString.charAt(++b);
/* 360 */         bool1 = false;
/* 361 */         bool = false;
/* 362 */       } else if (c == '%') {
/* 363 */         if (bool) {
/*     */           continue;
/*     */         }
/* 366 */         bool1 = true;
/* 367 */         bool = true;
/* 368 */       } else if (c == '_') {
/* 369 */         bool1 = true;
/*     */       } else {
/* 371 */         bool1 = false;
/* 372 */         bool = false;
/*     */       } 
/* 374 */       this.patternTypes[this.patternLength] = bool1;
/* 375 */       this.patternChars[this.patternLength++] = c; continue;
/*     */     } 
/* 377 */     for (b = 0; b < this.patternLength - 1; b++) {
/* 378 */       if (this.patternTypes[b] == 2 && this.patternTypes[b + 1] == 1) {
/* 379 */         this.patternTypes[b] = 1;
/* 380 */         this.patternTypes[b + 1] = 2;
/*     */       } 
/*     */     } 
/* 383 */     this.patternString = new String(this.patternChars, 0, this.patternLength);
/*     */ 
/*     */     
/* 386 */     if (this.compareMode.getName().equals("OFF") && this.patternLength > 1) {
/* 387 */       b = 0;
/* 388 */       while (b < this.patternLength && this.patternTypes[b] == 0) {
/* 389 */         b++;
/*     */       }
/* 391 */       if (b == this.patternLength - 1 && this.patternTypes[this.patternLength - 1] == 2) {
/* 392 */         this.shortcutToStartsWith = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isFullMatch() {
/* 398 */     if (this.patternTypes == null) {
/* 399 */       return false;
/*     */     }
/* 401 */     for (int i : this.patternTypes) {
/* 402 */       if (i != 0) {
/* 403 */         return false;
/*     */       }
/*     */     } 
/* 406 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 411 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 412 */     this.right.mapColumns(paramColumnResolver, paramInt);
/* 413 */     if (this.escape != null) {
/* 414 */       this.escape.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 420 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 421 */     this.right.setEvaluatable(paramTableFilter, paramBoolean);
/* 422 */     if (this.escape != null) {
/* 423 */       this.escape.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 429 */     this.left.updateAggregate(paramSession);
/* 430 */     this.right.updateAggregate(paramSession);
/* 431 */     if (this.escape != null) {
/* 432 */       this.escape.updateAggregate(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 438 */     return (this.left.isEverything(paramExpressionVisitor) && this.right.isEverything(paramExpressionVisitor) && (this.escape == null || this.escape.isEverything(paramExpressionVisitor)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 444 */     return this.left.getCost() + this.right.getCost() + 3;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\CompareLike.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */