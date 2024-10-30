/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ptg.AttrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.FuncVarPtg;
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
/*     */ final class ParseNode
/*     */ {
/*  34 */   public static final ParseNode[] EMPTY_ARRAY = new ParseNode[0];
/*     */   private final Ptg _token;
/*     */   private final ParseNode[] _children;
/*     */   private boolean _isIf;
/*     */   private final int _tokenCount;
/*     */   
/*     */   public ParseNode(Ptg paramPtg, ParseNode[] paramArrayOfParseNode) {
/*  41 */     if (paramPtg == null) {
/*  42 */       throw new IllegalArgumentException("token must not be null");
/*     */     }
/*  44 */     this._token = paramPtg;
/*  45 */     this._children = (ParseNode[])paramArrayOfParseNode.clone();
/*  46 */     this._isIf = isIf(paramPtg);
/*  47 */     int i = 1;
/*  48 */     for (byte b = 0; b < paramArrayOfParseNode.length; b++) {
/*  49 */       i += paramArrayOfParseNode[b].getTokenCount();
/*     */     }
/*  51 */     if (this._isIf)
/*     */     {
/*  53 */       i += paramArrayOfParseNode.length;
/*     */     }
/*  55 */     this._tokenCount = i;
/*     */   }
/*     */   public ParseNode(Ptg paramPtg) {
/*  58 */     this(paramPtg, EMPTY_ARRAY);
/*     */   }
/*     */   public ParseNode(Ptg paramPtg, ParseNode paramParseNode) {
/*  61 */     this(paramPtg, new ParseNode[] { paramParseNode });
/*     */   }
/*     */   public ParseNode(Ptg paramPtg, ParseNode paramParseNode1, ParseNode paramParseNode2) {
/*  64 */     this(paramPtg, new ParseNode[] { paramParseNode1, paramParseNode2 });
/*     */   }
/*     */   private int getTokenCount() {
/*  67 */     return this._tokenCount;
/*     */   }
/*     */   public int getEncodedSize() {
/*  70 */     int i = (this._token instanceof org.apache.poi.ss.formula.ptg.ArrayPtg) ? 8 : this._token.getSize();
/*  71 */     for (byte b = 0; b < this._children.length; b++) {
/*  72 */       i += this._children[b].getEncodedSize();
/*     */     }
/*  74 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Ptg[] toTokenArray(ParseNode paramParseNode) {
/*  81 */     TokenCollector tokenCollector = new TokenCollector(paramParseNode.getTokenCount());
/*  82 */     paramParseNode.collectPtgs(tokenCollector);
/*  83 */     return tokenCollector.getResult();
/*     */   }
/*     */   private void collectPtgs(TokenCollector paramTokenCollector) {
/*  86 */     if (isIf(this._token)) {
/*  87 */       collectIfPtgs(paramTokenCollector);
/*     */       return;
/*     */     } 
/*  90 */     boolean bool = (this._token instanceof org.apache.poi.ss.formula.ptg.MemFuncPtg || this._token instanceof org.apache.poi.ss.formula.ptg.MemAreaPtg) ? true : false;
/*  91 */     if (bool) {
/*  92 */       paramTokenCollector.add(this._token);
/*     */     }
/*  94 */     for (byte b = 0; b < (getChildren()).length; b++) {
/*  95 */       getChildren()[b].collectPtgs(paramTokenCollector);
/*     */     }
/*  97 */     if (!bool) {
/*  98 */       paramTokenCollector.add(this._token);
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
/*     */   private void collectIfPtgs(TokenCollector paramTokenCollector) {
/* 110 */     getChildren()[0].collectPtgs(paramTokenCollector);
/*     */ 
/*     */     
/* 113 */     int i = paramTokenCollector.createPlaceholder();
/*     */ 
/*     */     
/* 116 */     getChildren()[1].collectPtgs(paramTokenCollector);
/*     */ 
/*     */     
/* 119 */     int j = paramTokenCollector.createPlaceholder();
/* 120 */     int k = paramTokenCollector.sumTokenSizes(i + 1, j);
/*     */     
/* 122 */     AttrPtg attrPtg = AttrPtg.createIf(k + 4);
/*     */     
/* 124 */     if ((getChildren()).length > 2) {
/*     */ 
/*     */ 
/*     */       
/* 128 */       getChildren()[2].collectPtgs(paramTokenCollector);
/*     */       
/* 130 */       int m = paramTokenCollector.createPlaceholder();
/*     */       
/* 132 */       int n = paramTokenCollector.sumTokenSizes(j + 1, m);
/*     */       
/* 134 */       AttrPtg attrPtg1 = AttrPtg.createSkip(n + 4 + 4 - 1);
/* 135 */       AttrPtg attrPtg2 = AttrPtg.createSkip(3);
/*     */       
/* 137 */       paramTokenCollector.setPlaceholder(i, (Ptg)attrPtg);
/* 138 */       paramTokenCollector.setPlaceholder(j, (Ptg)attrPtg1);
/* 139 */       paramTokenCollector.setPlaceholder(m, (Ptg)attrPtg2);
/*     */     } else {
/*     */       
/* 142 */       AttrPtg attrPtg1 = AttrPtg.createSkip(3);
/*     */       
/* 144 */       paramTokenCollector.setPlaceholder(i, (Ptg)attrPtg);
/* 145 */       paramTokenCollector.setPlaceholder(j, (Ptg)attrPtg1);
/*     */     } 
/* 147 */     paramTokenCollector.add(this._token);
/*     */   }
/*     */   
/*     */   private static boolean isIf(Ptg paramPtg) {
/* 151 */     if (paramPtg instanceof FuncVarPtg) {
/* 152 */       FuncVarPtg funcVarPtg = (FuncVarPtg)paramPtg;
/* 153 */       if ("IF".equals(funcVarPtg.getName())) {
/* 154 */         return true;
/*     */       }
/*     */     } 
/* 157 */     return false;
/*     */   }
/*     */   
/*     */   public Ptg getToken() {
/* 161 */     return this._token;
/*     */   }
/*     */   
/*     */   public ParseNode[] getChildren() {
/* 165 */     return this._children;
/*     */   }
/*     */   
/*     */   private static final class TokenCollector
/*     */   {
/*     */     private final Ptg[] _ptgs;
/*     */     private int _offset;
/*     */     
/*     */     public TokenCollector(int param1Int) {
/* 174 */       this._ptgs = new Ptg[param1Int];
/* 175 */       this._offset = 0;
/*     */     }
/*     */     
/*     */     public int sumTokenSizes(int param1Int1, int param1Int2) {
/* 179 */       int i = 0;
/* 180 */       for (int j = param1Int1; j < param1Int2; j++) {
/* 181 */         i += this._ptgs[j].getSize();
/*     */       }
/* 183 */       return i;
/*     */     }
/*     */     
/*     */     public int createPlaceholder() {
/* 187 */       return this._offset++;
/*     */     }
/*     */     
/*     */     public void add(Ptg param1Ptg) {
/* 191 */       if (param1Ptg == null) {
/* 192 */         throw new IllegalArgumentException("token must not be null");
/*     */       }
/* 194 */       this._ptgs[this._offset] = param1Ptg;
/* 195 */       this._offset++;
/*     */     }
/*     */     
/*     */     public void setPlaceholder(int param1Int, Ptg param1Ptg) {
/* 199 */       if (this._ptgs[param1Int] != null) {
/* 200 */         throw new IllegalStateException("Invalid placeholder index (" + param1Int + ")");
/*     */       }
/* 202 */       this._ptgs[param1Int] = param1Ptg;
/*     */     }
/*     */     
/*     */     public Ptg[] getResult() {
/* 206 */       return this._ptgs;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ParseNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */