/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.util.Vector;
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
/*     */ class Op
/*     */ {
/*     */   static final int DOT = 0;
/*     */   static final int CHAR = 1;
/*     */   static final int RANGE = 3;
/*     */   static final int NRANGE = 4;
/*     */   static final int ANCHOR = 5;
/*     */   static final int STRING = 6;
/*     */   static final int CLOSURE = 7;
/*     */   static final int NONGREEDYCLOSURE = 8;
/*     */   static final int QUESTION = 9;
/*     */   static final int NONGREEDYQUESTION = 10;
/*     */   static final int UNION = 11;
/*     */   static final int CAPTURE = 15;
/*     */   static final int BACKREFERENCE = 16;
/*     */   static final int LOOKAHEAD = 20;
/*     */   static final int NEGATIVELOOKAHEAD = 21;
/*     */   static final int LOOKBEHIND = 22;
/*     */   static final int NEGATIVELOOKBEHIND = 23;
/*     */   static final int INDEPENDENT = 24;
/*     */   static final int MODIFIER = 25;
/*     */   static final int CONDITION = 26;
/*  44 */   static int nofinstances = 0;
/*     */   static final boolean COUNT = false;
/*     */   int type;
/*     */   
/*     */   static Op createDot() {
/*  49 */     return new Op(0);
/*     */   }
/*     */   
/*     */   static CharOp createChar(int paramInt) {
/*  53 */     return new CharOp(1, paramInt);
/*     */   }
/*     */   
/*     */   static CharOp createAnchor(int paramInt) {
/*  57 */     return new CharOp(5, paramInt);
/*     */   }
/*     */   
/*     */   static CharOp createCapture(int paramInt, Op paramOp) {
/*  61 */     CharOp charOp = new CharOp(15, paramInt);
/*  62 */     charOp.next = paramOp;
/*  63 */     return charOp;
/*     */   }
/*     */ 
/*     */   
/*     */   static UnionOp createUnion(int paramInt) {
/*  68 */     return new UnionOp(11, paramInt);
/*     */   }
/*     */   
/*     */   static ChildOp createClosure(int paramInt) {
/*  72 */     return new ModifierOp(7, paramInt, -1);
/*     */   }
/*     */   
/*     */   static ChildOp createNonGreedyClosure() {
/*  76 */     return new ChildOp(8);
/*     */   }
/*     */   
/*     */   static ChildOp createQuestion(boolean paramBoolean) {
/*  80 */     return new ChildOp(paramBoolean ? 10 : 9);
/*     */   }
/*     */   
/*     */   static RangeOp createRange(Token paramToken) {
/*  84 */     return new RangeOp(3, paramToken);
/*     */   }
/*     */   
/*     */   static ChildOp createLook(int paramInt, Op paramOp1, Op paramOp2) {
/*  88 */     ChildOp childOp = new ChildOp(paramInt);
/*  89 */     childOp.setChild(paramOp2);
/*  90 */     childOp.next = paramOp1;
/*  91 */     return childOp;
/*     */   }
/*     */   
/*     */   static CharOp createBackReference(int paramInt) {
/*  95 */     return new CharOp(16, paramInt);
/*     */   }
/*     */   
/*     */   static StringOp createString(String paramString) {
/*  99 */     return new StringOp(6, paramString);
/*     */   }
/*     */   
/*     */   static ChildOp createIndependent(Op paramOp1, Op paramOp2) {
/* 103 */     ChildOp childOp = new ChildOp(24);
/* 104 */     childOp.setChild(paramOp2);
/* 105 */     childOp.next = paramOp1;
/* 106 */     return childOp;
/*     */   }
/*     */   
/*     */   static ModifierOp createModifier(Op paramOp1, Op paramOp2, int paramInt1, int paramInt2) {
/* 110 */     ModifierOp modifierOp = new ModifierOp(25, paramInt1, paramInt2);
/* 111 */     modifierOp.setChild(paramOp2);
/* 112 */     modifierOp.next = paramOp1;
/* 113 */     return modifierOp;
/*     */   }
/*     */   
/*     */   static ConditionOp createCondition(Op paramOp1, int paramInt, Op paramOp2, Op paramOp3, Op paramOp4) {
/* 117 */     ConditionOp conditionOp = new ConditionOp(26, paramInt, paramOp2, paramOp3, paramOp4);
/* 118 */     conditionOp.next = paramOp1;
/* 119 */     return conditionOp;
/*     */   }
/*     */ 
/*     */   
/* 123 */   Op next = null;
/*     */   
/*     */   protected Op(int paramInt) {
/* 126 */     this.type = paramInt;
/*     */   }
/*     */   
/*     */   int size() {
/* 130 */     return 0;
/*     */   }
/*     */   Op elementAt(int paramInt) {
/* 133 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   Op getChild() {
/* 136 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   
/*     */   int getData() {
/* 140 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   int getData2() {
/* 143 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   RangeToken getToken() {
/* 146 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   String getString() {
/* 149 */     throw new RuntimeException("Internal Error: type=" + this.type);
/*     */   }
/*     */   
/*     */   static class CharOp extends Op {
/*     */     int charData;
/*     */     
/*     */     CharOp(int param1Int1, int param1Int2) {
/* 156 */       super(param1Int1);
/* 157 */       this.charData = param1Int2;
/*     */     }
/*     */     int getData() {
/* 160 */       return this.charData;
/*     */     }
/*     */   }
/*     */   
/*     */   static class UnionOp extends Op {
/*     */     Vector branches;
/*     */     
/*     */     UnionOp(int param1Int1, int param1Int2) {
/* 168 */       super(param1Int1);
/* 169 */       this.branches = new Vector(param1Int2);
/*     */     }
/*     */     void addElement(Op param1Op) {
/* 172 */       this.branches.addElement(param1Op);
/*     */     }
/*     */     int size() {
/* 175 */       return this.branches.size();
/*     */     }
/*     */     Op elementAt(int param1Int) {
/* 178 */       return this.branches.elementAt(param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   static class ChildOp extends Op {
/*     */     Op child;
/*     */     
/*     */     ChildOp(int param1Int) {
/* 186 */       super(param1Int);
/*     */     }
/*     */     void setChild(Op param1Op) {
/* 189 */       this.child = param1Op;
/*     */     }
/*     */     Op getChild() {
/* 192 */       return this.child;
/*     */     }
/*     */   }
/*     */   
/*     */   static class ModifierOp extends ChildOp { int v1;
/*     */     int v2;
/*     */     
/*     */     ModifierOp(int param1Int1, int param1Int2, int param1Int3) {
/* 200 */       super(param1Int1);
/* 201 */       this.v1 = param1Int2;
/* 202 */       this.v2 = param1Int3;
/*     */     }
/*     */     int getData() {
/* 205 */       return this.v1;
/*     */     }
/*     */     int getData2() {
/* 208 */       return this.v2;
/*     */     } }
/*     */   
/*     */   static class RangeOp extends Op {
/*     */     Token tok;
/*     */     
/*     */     RangeOp(int param1Int, Token param1Token) {
/* 215 */       super(param1Int);
/* 216 */       this.tok = param1Token;
/*     */     }
/*     */     RangeToken getToken() {
/* 219 */       return (RangeToken)this.tok;
/*     */     }
/*     */   }
/*     */   
/*     */   static class StringOp extends Op { String string;
/*     */     
/*     */     StringOp(int param1Int, String param1String) {
/* 226 */       super(param1Int);
/* 227 */       this.string = param1String;
/*     */     }
/*     */     String getString() {
/* 230 */       return this.string;
/*     */     } }
/*     */   
/*     */   static class ConditionOp extends Op {
/*     */     int refNumber;
/*     */     Op condition;
/*     */     Op yes;
/*     */     Op no;
/*     */     
/*     */     ConditionOp(int param1Int1, int param1Int2, Op param1Op1, Op param1Op2, Op param1Op3) {
/* 240 */       super(param1Int1);
/* 241 */       this.refNumber = param1Int2;
/* 242 */       this.condition = param1Op1;
/* 243 */       this.yes = param1Op2;
/* 244 */       this.no = param1Op3;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\Op.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */