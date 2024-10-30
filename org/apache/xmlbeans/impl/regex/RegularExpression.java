/*      */ package org.apache.xmlbeans.impl.regex;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.text.CharacterIterator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RegularExpression
/*      */   implements Serializable
/*      */ {
/*      */   static final boolean DEBUG = false;
/*      */   String regex;
/*      */   int options;
/*      */   int nofparen;
/*      */   Token tokentree;
/*      */   
/*      */   private synchronized void compile(Token paramToken) {
/*  487 */     if (this.operations != null)
/*      */       return; 
/*  489 */     this.numberOfClosures = 0;
/*  490 */     this.operations = compile(paramToken, null, false); } private Op compile(Token paramToken, Op paramOp, boolean paramBoolean) { Op op1; Op.UnionOp unionOp; byte b; Token token;
/*      */     int i;
/*      */     int j;
/*      */     Token.ConditionToken conditionToken;
/*      */     int k;
/*      */     Op op2;
/*      */     Op op3;
/*      */     Op op4;
/*  498 */     switch (paramToken.type) {
/*      */       case 11:
/*  500 */         op1 = Op.createDot();
/*  501 */         op1.next = paramOp;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  648 */         return op1;case 0: op1 = Op.createChar(paramToken.getChar()); op1.next = paramOp; return op1;case 8: op1 = Op.createAnchor(paramToken.getChar()); op1.next = paramOp; return op1;case 4: case 5: op1 = Op.createRange(paramToken); op1.next = paramOp; return op1;case 1: op1 = paramOp; if (!paramBoolean) { for (int m = paramToken.size() - 1; m >= 0; m--) op1 = compile(paramToken.getChild(m), op1, false);  } else { for (byte b1 = 0; b1 < paramToken.size(); b1++) op1 = compile(paramToken.getChild(b1), op1, true);  }  return op1;case 2: unionOp = Op.createUnion(paramToken.size()); for (b = 0; b < paramToken.size(); b++) unionOp.addElement(compile(paramToken.getChild(b), paramOp, paramBoolean));  op1 = unionOp; return op1;case 3: case 9: token = paramToken.getChild(0); i = paramToken.getMin(); j = paramToken.getMax(); if (i >= 0 && i == j) { op1 = paramOp; for (byte b1 = 0; b1 < i; b1++) op1 = compile(token, op1, paramBoolean);  } else { if (i > 0 && j > 0) j -= i;  if (j > 0) { op1 = paramOp; for (byte b1 = 0; b1 < j; b1++) { Op.ChildOp childOp = Op.createQuestion((paramToken.type == 9)); childOp.next = paramOp; childOp.setChild(compile(token, op1, paramBoolean)); op1 = childOp; }  } else { Op.ChildOp childOp; if (paramToken.type == 9) { childOp = Op.createNonGreedyClosure(); } else if (token.getMinLength() == 0) { childOp = Op.createClosure(this.numberOfClosures++); } else { childOp = Op.createClosure(-1); }  childOp.next = paramOp; childOp.setChild(compile(token, childOp, paramBoolean)); op1 = childOp; }  if (i > 0) for (byte b1 = 0; b1 < i; b1++) op1 = compile(token, op1, paramBoolean);   }  return op1;case 7: op1 = paramOp; return op1;case 10: op1 = Op.createString(paramToken.getString()); op1.next = paramOp; return op1;case 12: op1 = Op.createBackReference(paramToken.getReferenceNumber()); op1.next = paramOp; return op1;case 6: if (paramToken.getParenNumber() == 0) { op1 = compile(paramToken.getChild(0), paramOp, paramBoolean); } else if (paramBoolean) { paramOp = Op.createCapture(paramToken.getParenNumber(), paramOp); paramOp = compile(paramToken.getChild(0), paramOp, paramBoolean); op1 = Op.createCapture(-paramToken.getParenNumber(), paramOp); } else { paramOp = Op.createCapture(-paramToken.getParenNumber(), paramOp); paramOp = compile(paramToken.getChild(0), paramOp, paramBoolean); op1 = Op.createCapture(paramToken.getParenNumber(), paramOp); }  return op1;case 20: op1 = Op.createLook(20, paramOp, compile(paramToken.getChild(0), null, false)); return op1;case 21: op1 = Op.createLook(21, paramOp, compile(paramToken.getChild(0), null, false)); return op1;case 22: op1 = Op.createLook(22, paramOp, compile(paramToken.getChild(0), null, true)); return op1;case 23: op1 = Op.createLook(23, paramOp, compile(paramToken.getChild(0), null, true)); return op1;case 24: op1 = Op.createIndependent(paramOp, compile(paramToken.getChild(0), null, paramBoolean)); return op1;case 25: op1 = Op.createModifier(paramOp, compile(paramToken.getChild(0), null, paramBoolean), ((Token.ModifierToken)paramToken).getOptions(), ((Token.ModifierToken)paramToken).getOptionsMask()); return op1;case 26: conditionToken = (Token.ConditionToken)paramToken; k = conditionToken.refNumber; op2 = (conditionToken.condition == null) ? null : compile(conditionToken.condition, null, paramBoolean); op3 = compile(conditionToken.yes, paramOp, paramBoolean); op4 = (conditionToken.no == null) ? null : compile(conditionToken.no, paramOp, paramBoolean); op1 = Op.createCondition(paramOp, k, op2, op3, op4); return op1;
/*      */     } 
/*      */     throw new RuntimeException("Unknown token type: " + paramToken.type); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(char[] paramArrayOfchar) {
/*  660 */     return matches(paramArrayOfchar, 0, paramArrayOfchar.length, (Match)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  672 */     return matches(paramArrayOfchar, paramInt1, paramInt2, (Match)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(char[] paramArrayOfchar, Match paramMatch) {
/*  682 */     return matches(paramArrayOfchar, 0, paramArrayOfchar.length, paramMatch);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(char[] paramArrayOfchar, int paramInt1, int paramInt2, Match paramMatch) {
/*      */     int j;
/*  697 */     synchronized (this) {
/*  698 */       if (this.operations == null)
/*  699 */         prepare(); 
/*  700 */       if (this.context == null)
/*  701 */         this.context = new Context(); 
/*      */     } 
/*  703 */     Context context = null;
/*  704 */     synchronized (this.context) {
/*  705 */       context = this.context.inuse ? new Context() : this.context;
/*  706 */       context.reset(paramArrayOfchar, paramInt1, paramInt2, this.numberOfClosures);
/*      */     } 
/*  708 */     if (paramMatch != null) {
/*  709 */       paramMatch.setNumberOfGroups(this.nofparen);
/*  710 */       paramMatch.setSource(paramArrayOfchar);
/*  711 */     } else if (this.hasBackReferences) {
/*  712 */       paramMatch = new Match();
/*  713 */       paramMatch.setNumberOfGroups(this.nofparen);
/*      */     } 
/*      */ 
/*      */     
/*  717 */     context.match = paramMatch;
/*      */     
/*  719 */     if (isSet(this.options, 512)) {
/*  720 */       int m = matchCharArray(context, this.operations, context.start, 1, this.options);
/*      */       
/*  722 */       if (m == context.limit) {
/*  723 */         if (context.match != null) {
/*  724 */           context.match.setBeginning(0, context.start);
/*  725 */           context.match.setEnd(0, m);
/*      */         } 
/*  727 */         context.inuse = false;
/*  728 */         return true;
/*      */       } 
/*  730 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  737 */     if (this.fixedStringOnly) {
/*      */       
/*  739 */       int m = this.fixedStringTable.matches(paramArrayOfchar, context.start, context.limit);
/*  740 */       if (m >= 0) {
/*  741 */         if (context.match != null) {
/*  742 */           context.match.setBeginning(0, m);
/*  743 */           context.match.setEnd(0, m + this.fixedString.length());
/*      */         } 
/*  745 */         context.inuse = false;
/*  746 */         return true;
/*      */       } 
/*  748 */       context.inuse = false;
/*  749 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  757 */     if (this.fixedString != null) {
/*  758 */       int m = this.fixedStringTable.matches(paramArrayOfchar, context.start, context.limit);
/*  759 */       if (m < 0) {
/*      */         
/*  761 */         context.inuse = false;
/*  762 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/*  766 */     int i = context.limit - this.minlength;
/*      */     
/*  768 */     int k = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  773 */     if (this.operations != null && this.operations.type == 7 && (this.operations.getChild()).type == 0) {
/*      */       
/*  775 */       if (isSet(this.options, 4)) {
/*  776 */         j = context.start;
/*  777 */         k = matchCharArray(context, this.operations, context.start, 1, this.options);
/*      */       } else {
/*  779 */         boolean bool = true;
/*  780 */         for (j = context.start; j <= i; j++) {
/*  781 */           char c = paramArrayOfchar[j];
/*  782 */           if (isEOLChar(c)) {
/*  783 */             bool = true;
/*      */           } else {
/*  785 */             if (bool && 
/*  786 */               0 <= (k = matchCharArray(context, this.operations, j, 1, this.options))) {
/*      */               break;
/*      */             }
/*      */             
/*  790 */             bool = false;
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*  799 */     else if (this.firstChar != null) {
/*      */       
/*  801 */       RangeToken rangeToken = this.firstChar;
/*  802 */       if (isSet(this.options, 2)) {
/*  803 */         rangeToken = this.firstChar.getCaseInsensitiveToken();
/*  804 */         for (j = context.start; j <= i; j++) {
/*  805 */           int m = paramArrayOfchar[j];
/*  806 */           if (REUtil.isHighSurrogate(m) && j + 1 < context.limit) {
/*  807 */             m = REUtil.composeFromSurrogates(m, paramArrayOfchar[j + 1]);
/*  808 */             if (!rangeToken.match(m))
/*      */               continue; 
/*  810 */           } else if (!rangeToken.match(m)) {
/*  811 */             char c = Character.toUpperCase((char)m);
/*  812 */             if (!rangeToken.match(c) && 
/*  813 */               !rangeToken.match(Character.toLowerCase(c))) {
/*      */               continue;
/*      */             }
/*      */           } 
/*  817 */           if (0 <= (k = matchCharArray(context, this.operations, j, 1, this.options)))
/*      */             break; 
/*      */           continue;
/*      */         } 
/*      */       } else {
/*  822 */         for (j = context.start; j <= i; j++) {
/*  823 */           int m = paramArrayOfchar[j];
/*  824 */           if (REUtil.isHighSurrogate(m) && j + 1 < context.limit)
/*  825 */             m = REUtil.composeFromSurrogates(m, paramArrayOfchar[j + 1]); 
/*  826 */           if (rangeToken.match(m) && 
/*  827 */             0 <= (k = matchCharArray(context, this.operations, j, 1, this.options)))
/*      */           {
/*      */             break;
/*      */           }
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  838 */       for (j = context.start; j <= i && 
/*  839 */         0 > (k = matchCharArray(context, this.operations, j, 1, this.options)); j++);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  844 */     if (k >= 0) {
/*  845 */       if (context.match != null) {
/*  846 */         context.match.setBeginning(0, j);
/*  847 */         context.match.setEnd(0, k);
/*      */       } 
/*  849 */       context.inuse = false;
/*  850 */       return true;
/*      */     } 
/*  852 */     context.inuse = false;
/*  853 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int matchCharArray(Context paramContext, Op paramOp, int paramInt1, int paramInt2, int paramInt3) {
/*  862 */     char[] arrayOfChar = paramContext.charTarget; while (true) {
/*      */       boolean bool; int j; String str; int i; int k;
/*      */       Op.ConditionOp conditionOp;
/*      */       int m;
/*  866 */       if (paramOp == null)
/*  867 */         return (isSet(paramInt3, 512) && paramInt1 != paramContext.limit) ? -1 : paramInt1; 
/*  868 */       if (paramInt1 > paramContext.limit || paramInt1 < paramContext.start)
/*  869 */         return -1; 
/*  870 */       switch (paramOp.type) {
/*      */         case 1:
/*  872 */           if (isSet(paramInt3, 2)) {
/*  873 */             int n = paramOp.getData();
/*  874 */             if (paramInt2 > 0) {
/*  875 */               if (paramInt1 >= paramContext.limit || !matchIgnoreCase(n, arrayOfChar[paramInt1]))
/*  876 */                 return -1; 
/*  877 */               paramInt1++;
/*      */             } else {
/*  879 */               int i1 = paramInt1 - 1;
/*  880 */               if (i1 >= paramContext.limit || i1 < 0 || !matchIgnoreCase(n, arrayOfChar[i1]))
/*  881 */                 return -1; 
/*  882 */               paramInt1 = i1;
/*      */             } 
/*      */           } else {
/*  885 */             int n = paramOp.getData();
/*  886 */             if (paramInt2 > 0) {
/*  887 */               if (paramInt1 >= paramContext.limit || n != arrayOfChar[paramInt1])
/*  888 */                 return -1; 
/*  889 */               paramInt1++;
/*      */             } else {
/*  891 */               int i1 = paramInt1 - 1;
/*  892 */               if (i1 >= paramContext.limit || i1 < 0 || n != arrayOfChar[i1])
/*  893 */                 return -1; 
/*  894 */               paramInt1 = i1;
/*      */             } 
/*      */           } 
/*  897 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 0:
/*  901 */           if (paramInt2 > 0) {
/*  902 */             if (paramInt1 >= paramContext.limit)
/*  903 */               return -1; 
/*  904 */             char c = arrayOfChar[paramInt1];
/*  905 */             if (isSet(paramInt3, 4)) {
/*  906 */               if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/*  907 */                 paramInt1++; 
/*      */             } else {
/*  909 */               int n; if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/*  910 */                 n = REUtil.composeFromSurrogates(c, arrayOfChar[++paramInt1]); 
/*  911 */               if (isEOLChar(n))
/*  912 */                 return -1; 
/*      */             } 
/*  914 */             paramInt1++;
/*      */           } else {
/*  916 */             int n = paramInt1 - 1;
/*  917 */             if (n >= paramContext.limit || n < 0)
/*  918 */               return -1; 
/*  919 */             char c = arrayOfChar[n];
/*  920 */             if (isSet(paramInt3, 4)) {
/*  921 */               if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/*  922 */                 n--; 
/*      */             } else {
/*  924 */               int i1; if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/*  925 */                 i1 = REUtil.composeFromSurrogates(arrayOfChar[--n], c); 
/*  926 */               if (!isEOLChar(i1))
/*  927 */                 return -1; 
/*      */             } 
/*  929 */             paramInt1 = n;
/*      */           } 
/*  931 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 3:
/*      */         case 4:
/*  936 */           if (paramInt2 > 0) {
/*  937 */             if (paramInt1 >= paramContext.limit)
/*  938 */               return -1; 
/*  939 */             int n = arrayOfChar[paramInt1];
/*  940 */             if (REUtil.isHighSurrogate(n) && paramInt1 + 1 < paramContext.limit)
/*  941 */               n = REUtil.composeFromSurrogates(n, arrayOfChar[++paramInt1]); 
/*  942 */             RangeToken rangeToken = paramOp.getToken();
/*  943 */             if (isSet(paramInt3, 2))
/*  944 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/*  945 */               if (!rangeToken.match(n)) {
/*  946 */                 if (n >= 65536) return -1; 
/*      */                 char c;
/*  948 */                 if (!rangeToken.match(c = Character.toUpperCase((char)n)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/*  950 */                   return -1;
/*      */                 }
/*      */               }  }
/*  953 */             else if (!rangeToken.match(n)) { return -1; }
/*      */             
/*  955 */             paramInt1++;
/*      */           } else {
/*  957 */             int n = paramInt1 - 1;
/*  958 */             if (n >= paramContext.limit || n < 0)
/*  959 */               return -1; 
/*  960 */             int i1 = arrayOfChar[n];
/*  961 */             if (REUtil.isLowSurrogate(i1) && n - 1 >= 0)
/*  962 */               i1 = REUtil.composeFromSurrogates(arrayOfChar[--n], i1); 
/*  963 */             RangeToken rangeToken = paramOp.getToken();
/*  964 */             if (isSet(paramInt3, 2))
/*  965 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/*  966 */               if (!rangeToken.match(i1)) {
/*  967 */                 if (i1 >= 65536) return -1; 
/*      */                 char c;
/*  969 */                 if (!rangeToken.match(c = Character.toUpperCase((char)i1)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/*  971 */                   return -1;
/*      */                 }
/*      */               }  }
/*  974 */             else if (!rangeToken.match(i1)) { return -1; }
/*      */             
/*  976 */             paramInt1 = n;
/*      */           } 
/*  978 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 5:
/*  982 */           bool = false;
/*  983 */           switch (paramOp.getData()) {
/*      */             case 94:
/*  985 */               if (isSet(paramInt3, 8)) {
/*  986 */                 if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(arrayOfChar[paramInt1 - 1])))
/*      */                 {
/*  988 */                   return -1; }  break;
/*      */               } 
/*  990 */               if (paramInt1 != paramContext.start) {
/*  991 */                 return -1;
/*      */               }
/*      */               break;
/*      */ 
/*      */             
/*      */             case 64:
/*  997 */               if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(arrayOfChar[paramInt1 - 1])))
/*      */               {
/*  999 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 36:
/* 1003 */               if (isSet(paramInt3, 8)) {
/* 1004 */                 if (paramInt1 != paramContext.limit && (paramInt1 >= paramContext.limit || !isEOLChar(arrayOfChar[paramInt1])))
/*      */                 {
/* 1006 */                   return -1; }  break;
/*      */               } 
/* 1008 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(arrayOfChar[paramInt1])) && (paramInt1 + 2 != paramContext.limit || arrayOfChar[paramInt1] != '\r' || arrayOfChar[paramInt1 + 1] != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 1012 */                 return -1;
/*      */               }
/*      */               break;
/*      */             
/*      */             case 65:
/* 1017 */               if (paramInt1 != paramContext.start) return -1;
/*      */               
/*      */               break;
/*      */             case 90:
/* 1021 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(arrayOfChar[paramInt1])) && (paramInt1 + 2 != paramContext.limit || arrayOfChar[paramInt1] != '\r' || arrayOfChar[paramInt1 + 1] != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 1025 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 122:
/* 1029 */               if (paramInt1 != paramContext.limit) return -1;
/*      */               
/*      */               break;
/*      */             case 98:
/* 1033 */               if (paramContext.length == 0) return -1;
/*      */               
/* 1035 */               j = getWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1036 */               if (j == 0) return -1; 
/* 1037 */               k = getPreviousWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1038 */               if (j == k) return -1;
/*      */               
/*      */               break;
/*      */             
/*      */             case 66:
/* 1043 */               if (paramContext.length == 0) {
/* 1044 */                 bool = true;
/*      */               } else {
/* 1046 */                 j = getWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1047 */                 bool = (j == 0 || j == getPreviousWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3)) ? true : false;
/*      */               } 
/*      */               
/* 1050 */               if (!bool) return -1;
/*      */               
/*      */               break;
/*      */             case 60:
/* 1054 */               if (paramContext.length == 0 || paramInt1 == paramContext.limit) return -1; 
/* 1055 */               if (getWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1 || getPreviousWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2)
/*      */               {
/* 1057 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 62:
/* 1061 */               if (paramContext.length == 0 || paramInt1 == paramContext.start) return -1; 
/* 1062 */               if (getWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2 || getPreviousWordType(arrayOfChar, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1)
/*      */               {
/* 1064 */                 return -1; } 
/*      */               break;
/*      */           } 
/* 1067 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 16:
/* 1072 */           j = paramOp.getData();
/* 1073 */           if (j <= 0 || j >= this.nofparen)
/* 1074 */             throw new RuntimeException("Internal Error: Reference number must be more than zero: " + j); 
/* 1075 */           if (paramContext.match.getBeginning(j) < 0 || paramContext.match.getEnd(j) < 0)
/*      */           {
/* 1077 */             return -1; } 
/* 1078 */           k = paramContext.match.getBeginning(j);
/* 1079 */           m = paramContext.match.getEnd(j) - k;
/* 1080 */           if (!isSet(paramInt3, 2)) {
/* 1081 */             if (paramInt2 > 0) {
/* 1082 */               if (!regionMatches(arrayOfChar, paramInt1, paramContext.limit, k, m))
/* 1083 */                 return -1; 
/* 1084 */               paramInt1 += m;
/*      */             } else {
/* 1086 */               if (!regionMatches(arrayOfChar, paramInt1 - m, paramContext.limit, k, m))
/* 1087 */                 return -1; 
/* 1088 */               paramInt1 -= m;
/*      */             }
/*      */           
/* 1091 */           } else if (paramInt2 > 0) {
/* 1092 */             if (!regionMatchesIgnoreCase(arrayOfChar, paramInt1, paramContext.limit, k, m))
/* 1093 */               return -1; 
/* 1094 */             paramInt1 += m;
/*      */           } else {
/* 1096 */             if (!regionMatchesIgnoreCase(arrayOfChar, paramInt1 - m, paramContext.limit, k, m))
/*      */             {
/* 1098 */               return -1; } 
/* 1099 */             paramInt1 -= m;
/*      */           } 
/*      */ 
/*      */           
/* 1103 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 6:
/* 1107 */           str = paramOp.getString();
/* 1108 */           k = str.length();
/* 1109 */           if (!isSet(paramInt3, 2)) {
/* 1110 */             if (paramInt2 > 0) {
/* 1111 */               if (!regionMatches(arrayOfChar, paramInt1, paramContext.limit, str, k))
/* 1112 */                 return -1; 
/* 1113 */               paramInt1 += k;
/*      */             } else {
/* 1115 */               if (!regionMatches(arrayOfChar, paramInt1 - k, paramContext.limit, str, k))
/* 1116 */                 return -1; 
/* 1117 */               paramInt1 -= k;
/*      */             }
/*      */           
/* 1120 */           } else if (paramInt2 > 0) {
/* 1121 */             if (!regionMatchesIgnoreCase(arrayOfChar, paramInt1, paramContext.limit, str, k))
/* 1122 */               return -1; 
/* 1123 */             paramInt1 += k;
/*      */           } else {
/* 1125 */             if (!regionMatchesIgnoreCase(arrayOfChar, paramInt1 - k, paramContext.limit, str, k))
/*      */             {
/* 1127 */               return -1; } 
/* 1128 */             paramInt1 -= k;
/*      */           } 
/*      */ 
/*      */           
/* 1132 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 7:
/* 1141 */           i = paramOp.getData();
/* 1142 */           if (i >= 0) {
/* 1143 */             k = paramContext.offsets[i];
/* 1144 */             if (k < 0 || k != paramInt1) {
/* 1145 */               paramContext.offsets[i] = paramInt1;
/*      */             } else {
/* 1147 */               paramContext.offsets[i] = -1;
/* 1148 */               paramOp = paramOp.next;
/*      */               
/*      */               continue;
/*      */             } 
/*      */           } 
/* 1153 */           k = matchCharArray(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1154 */           if (i >= 0) paramContext.offsets[i] = -1; 
/* 1155 */           if (k >= 0) return k; 
/* 1156 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 9:
/* 1162 */           i = matchCharArray(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1163 */           if (i >= 0) return i; 
/* 1164 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 8:
/*      */         case 10:
/* 1171 */           i = matchCharArray(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1172 */           if (i >= 0) return i; 
/* 1173 */           paramOp = paramOp.getChild();
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 11:
/* 1178 */           for (i = 0; i < paramOp.size(); i++) {
/* 1179 */             k = matchCharArray(paramContext, paramOp.elementAt(i), paramInt1, paramInt2, paramInt3);
/*      */ 
/*      */ 
/*      */             
/* 1183 */             if (k >= 0) return k; 
/*      */           } 
/* 1185 */           return -1;
/*      */         
/*      */         case 15:
/* 1188 */           i = paramOp.getData();
/* 1189 */           if (paramContext.match != null && i > 0) {
/* 1190 */             k = paramContext.match.getBeginning(i);
/* 1191 */             paramContext.match.setBeginning(i, paramInt1);
/* 1192 */             m = matchCharArray(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1193 */             if (m < 0) paramContext.match.setBeginning(i, k); 
/* 1194 */             return m;
/* 1195 */           }  if (paramContext.match != null && i < 0) {
/* 1196 */             k = -i;
/* 1197 */             m = paramContext.match.getEnd(k);
/* 1198 */             paramContext.match.setEnd(k, paramInt1);
/* 1199 */             int n = matchCharArray(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1200 */             if (n < 0) paramContext.match.setEnd(k, m); 
/* 1201 */             return n;
/*      */           } 
/* 1203 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 20:
/* 1207 */           if (0 > matchCharArray(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 1208 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 21:
/* 1211 */           if (0 <= matchCharArray(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 1212 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 22:
/* 1215 */           if (0 > matchCharArray(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 1216 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 23:
/* 1219 */           if (0 <= matchCharArray(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 1220 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 24:
/* 1225 */           k = matchCharArray(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1226 */           if (k < 0) return k; 
/* 1227 */           paramInt1 = k;
/* 1228 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 25:
/* 1234 */           k = paramInt3;
/* 1235 */           k |= paramOp.getData();
/* 1236 */           k &= paramOp.getData2() ^ 0xFFFFFFFF;
/*      */           
/* 1238 */           m = matchCharArray(paramContext, paramOp.getChild(), paramInt1, paramInt2, k);
/* 1239 */           if (m < 0) return m; 
/* 1240 */           paramInt1 = m;
/* 1241 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 26:
/* 1247 */           conditionOp = (Op.ConditionOp)paramOp;
/* 1248 */           m = 0;
/* 1249 */           if (conditionOp.refNumber > 0) {
/* 1250 */             if (conditionOp.refNumber >= this.nofparen)
/* 1251 */               throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber); 
/* 1252 */             m = (paramContext.match.getBeginning(conditionOp.refNumber) >= 0 && paramContext.match.getEnd(conditionOp.refNumber) >= 0) ? 1 : 0;
/*      */           } else {
/*      */             
/* 1255 */             m = (0 <= matchCharArray(paramContext, conditionOp.condition, paramInt1, paramInt2, paramInt3)) ? 1 : 0;
/*      */           } 
/*      */           
/* 1258 */           if (m != 0) {
/* 1259 */             paramOp = conditionOp.yes; continue;
/* 1260 */           }  if (conditionOp.no != null) {
/* 1261 */             paramOp = conditionOp.no; continue;
/*      */           } 
/* 1263 */           paramOp = conditionOp.next;
/*      */           continue;
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/* 1269 */     throw new RuntimeException("Unknown operation type: " + paramOp.type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int getPreviousWordType(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1276 */     int i = getWordType(paramArrayOfchar, paramInt1, paramInt2, --paramInt3, paramInt4);
/* 1277 */     while (i == 0)
/* 1278 */       i = getWordType(paramArrayOfchar, paramInt1, paramInt2, --paramInt3, paramInt4); 
/* 1279 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int getWordType(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1284 */     if (paramInt3 < paramInt1 || paramInt3 >= paramInt2) return 2; 
/* 1285 */     return getWordType0(paramArrayOfchar[paramInt3], paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(char[] paramArrayOfchar, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/* 1292 */     if (paramInt1 < 0) return false; 
/* 1293 */     if (paramInt2 - paramInt1 < paramInt3)
/* 1294 */       return false; 
/* 1295 */     byte b = 0;
/* 1296 */     while (paramInt3-- > 0) {
/* 1297 */       if (paramArrayOfchar[paramInt1++] != paramString.charAt(b++))
/* 1298 */         return false; 
/*      */     } 
/* 1300 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1305 */     if (paramInt1 < 0) return false; 
/* 1306 */     if (paramInt2 - paramInt1 < paramInt4)
/* 1307 */       return false; 
/* 1308 */     int i = paramInt3;
/* 1309 */     while (paramInt4-- > 0) {
/* 1310 */       if (paramArrayOfchar[paramInt1++] != paramArrayOfchar[i++])
/* 1311 */         return false; 
/*      */     } 
/* 1313 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(char[] paramArrayOfchar, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/* 1321 */     if (paramInt1 < 0) return false; 
/* 1322 */     if (paramInt2 - paramInt1 < paramInt3)
/* 1323 */       return false; 
/* 1324 */     byte b = 0;
/* 1325 */     while (paramInt3-- > 0) {
/* 1326 */       char c1 = paramArrayOfchar[paramInt1++];
/* 1327 */       char c2 = paramString.charAt(b++);
/* 1328 */       if (c1 == c2)
/*      */         continue; 
/* 1330 */       char c3 = Character.toUpperCase(c1);
/* 1331 */       char c4 = Character.toUpperCase(c2);
/* 1332 */       if (c3 == c4)
/*      */         continue; 
/* 1334 */       if (Character.toLowerCase(c3) != Character.toLowerCase(c4))
/* 1335 */         return false; 
/*      */     } 
/* 1337 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1342 */     if (paramInt1 < 0) return false; 
/* 1343 */     if (paramInt2 - paramInt1 < paramInt4)
/* 1344 */       return false; 
/* 1345 */     int i = paramInt3;
/* 1346 */     while (paramInt4-- > 0) {
/* 1347 */       char c1 = paramArrayOfchar[paramInt1++];
/* 1348 */       char c2 = paramArrayOfchar[i++];
/* 1349 */       if (c1 == c2)
/*      */         continue; 
/* 1351 */       char c3 = Character.toUpperCase(c1);
/* 1352 */       char c4 = Character.toUpperCase(c2);
/* 1353 */       if (c3 == c4)
/*      */         continue; 
/* 1355 */       if (Character.toLowerCase(c3) != Character.toLowerCase(c4))
/* 1356 */         return false; 
/*      */     } 
/* 1358 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(String paramString) {
/* 1370 */     return matches(paramString, 0, paramString.length(), (Match)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(String paramString, int paramInt1, int paramInt2) {
/* 1382 */     return matches(paramString, paramInt1, paramInt2, (Match)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(String paramString, Match paramMatch) {
/* 1392 */     return matches(paramString, 0, paramString.length(), paramMatch);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(String paramString, int paramInt1, int paramInt2, Match paramMatch) {
/*      */     int j;
/* 1406 */     synchronized (this) {
/* 1407 */       if (this.operations == null)
/* 1408 */         prepare(); 
/* 1409 */       if (this.context == null)
/* 1410 */         this.context = new Context(); 
/*      */     } 
/* 1412 */     Context context = null;
/* 1413 */     synchronized (this.context) {
/* 1414 */       context = this.context.inuse ? new Context() : this.context;
/* 1415 */       context.reset(paramString, paramInt1, paramInt2, this.numberOfClosures);
/*      */     } 
/* 1417 */     if (paramMatch != null) {
/* 1418 */       paramMatch.setNumberOfGroups(this.nofparen);
/* 1419 */       paramMatch.setSource(paramString);
/* 1420 */     } else if (this.hasBackReferences) {
/* 1421 */       paramMatch = new Match();
/* 1422 */       paramMatch.setNumberOfGroups(this.nofparen);
/*      */     } 
/*      */ 
/*      */     
/* 1426 */     context.match = paramMatch;
/*      */     
/* 1428 */     if (isSet(this.options, 512)) {
/*      */ 
/*      */ 
/*      */       
/* 1432 */       int m = matchString(context, this.operations, context.start, 1, this.options);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1437 */       if (m == context.limit) {
/* 1438 */         if (context.match != null) {
/* 1439 */           context.match.setBeginning(0, context.start);
/* 1440 */           context.match.setEnd(0, m);
/*      */         } 
/* 1442 */         context.inuse = false;
/* 1443 */         return true;
/*      */       } 
/* 1445 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1452 */     if (this.fixedStringOnly) {
/*      */       
/* 1454 */       int m = this.fixedStringTable.matches(paramString, context.start, context.limit);
/* 1455 */       if (m >= 0) {
/* 1456 */         if (context.match != null) {
/* 1457 */           context.match.setBeginning(0, m);
/* 1458 */           context.match.setEnd(0, m + this.fixedString.length());
/*      */         } 
/* 1460 */         context.inuse = false;
/* 1461 */         return true;
/*      */       } 
/* 1463 */       context.inuse = false;
/* 1464 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1472 */     if (this.fixedString != null) {
/* 1473 */       int m = this.fixedStringTable.matches(paramString, context.start, context.limit);
/* 1474 */       if (m < 0) {
/*      */         
/* 1476 */         context.inuse = false;
/* 1477 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/* 1481 */     int i = context.limit - this.minlength;
/*      */     
/* 1483 */     int k = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1488 */     if (this.operations != null && this.operations.type == 7 && (this.operations.getChild()).type == 0) {
/*      */       
/* 1490 */       if (isSet(this.options, 4)) {
/* 1491 */         j = context.start;
/* 1492 */         k = matchString(context, this.operations, context.start, 1, this.options);
/*      */       } else {
/* 1494 */         boolean bool = true;
/* 1495 */         for (j = context.start; j <= i; j++) {
/* 1496 */           char c = paramString.charAt(j);
/* 1497 */           if (isEOLChar(c)) {
/* 1498 */             bool = true;
/*      */           } else {
/* 1500 */             if (bool && 
/* 1501 */               0 <= (k = matchString(context, this.operations, j, 1, this.options))) {
/*      */               break;
/*      */             }
/*      */             
/* 1505 */             bool = false;
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 1514 */     else if (this.firstChar != null) {
/*      */       
/* 1516 */       RangeToken rangeToken = this.firstChar;
/* 1517 */       if (isSet(this.options, 2)) {
/* 1518 */         rangeToken = this.firstChar.getCaseInsensitiveToken();
/* 1519 */         for (j = context.start; j <= i; j++) {
/* 1520 */           int m = paramString.charAt(j);
/* 1521 */           if (REUtil.isHighSurrogate(m) && j + 1 < context.limit) {
/* 1522 */             m = REUtil.composeFromSurrogates(m, paramString.charAt(j + 1));
/* 1523 */             if (!rangeToken.match(m))
/*      */               continue; 
/* 1525 */           } else if (!rangeToken.match(m)) {
/* 1526 */             char c = Character.toUpperCase((char)m);
/* 1527 */             if (!rangeToken.match(c) && 
/* 1528 */               !rangeToken.match(Character.toLowerCase(c))) {
/*      */               continue;
/*      */             }
/*      */           } 
/* 1532 */           if (0 <= (k = matchString(context, this.operations, j, 1, this.options)))
/*      */             break; 
/*      */           continue;
/*      */         } 
/*      */       } else {
/* 1537 */         for (j = context.start; j <= i; j++) {
/* 1538 */           int m = paramString.charAt(j);
/* 1539 */           if (REUtil.isHighSurrogate(m) && j + 1 < context.limit)
/* 1540 */             m = REUtil.composeFromSurrogates(m, paramString.charAt(j + 1)); 
/* 1541 */           if (rangeToken.match(m) && 
/* 1542 */             0 <= (k = matchString(context, this.operations, j, 1, this.options)))
/*      */           {
/*      */             break;
/*      */           }
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1553 */       for (j = context.start; j <= i && 
/* 1554 */         0 > (k = matchString(context, this.operations, j, 1, this.options)); j++);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1559 */     if (k >= 0) {
/* 1560 */       if (context.match != null) {
/* 1561 */         context.match.setBeginning(0, j);
/* 1562 */         context.match.setEnd(0, k);
/*      */       } 
/* 1564 */       context.inuse = false;
/* 1565 */       return true;
/*      */     } 
/* 1567 */     context.inuse = false;
/* 1568 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int matchString(Context paramContext, Op paramOp, int paramInt1, int paramInt2, int paramInt3) {
/* 1580 */     String str = paramContext.strTarget; while (true) {
/*      */       boolean bool; int j; String str1;
/*      */       int i;
/*      */       int k;
/*      */       Op.ConditionOp conditionOp;
/*      */       int m;
/* 1586 */       if (paramOp == null)
/* 1587 */         return (isSet(paramInt3, 512) && paramInt1 != paramContext.limit) ? -1 : paramInt1; 
/* 1588 */       if (paramInt1 > paramContext.limit || paramInt1 < paramContext.start)
/* 1589 */         return -1; 
/* 1590 */       switch (paramOp.type) {
/*      */         case 1:
/* 1592 */           if (isSet(paramInt3, 2)) {
/* 1593 */             int n = paramOp.getData();
/* 1594 */             if (paramInt2 > 0) {
/* 1595 */               if (paramInt1 >= paramContext.limit || !matchIgnoreCase(n, str.charAt(paramInt1)))
/* 1596 */                 return -1; 
/* 1597 */               paramInt1++;
/*      */             } else {
/* 1599 */               int i1 = paramInt1 - 1;
/* 1600 */               if (i1 >= paramContext.limit || i1 < 0 || !matchIgnoreCase(n, str.charAt(i1)))
/* 1601 */                 return -1; 
/* 1602 */               paramInt1 = i1;
/*      */             } 
/*      */           } else {
/* 1605 */             int n = paramOp.getData();
/* 1606 */             if (paramInt2 > 0) {
/* 1607 */               if (paramInt1 >= paramContext.limit || n != str.charAt(paramInt1))
/* 1608 */                 return -1; 
/* 1609 */               paramInt1++;
/*      */             } else {
/* 1611 */               int i1 = paramInt1 - 1;
/* 1612 */               if (i1 >= paramContext.limit || i1 < 0 || n != str.charAt(i1))
/* 1613 */                 return -1; 
/* 1614 */               paramInt1 = i1;
/*      */             } 
/*      */           } 
/* 1617 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 0:
/* 1621 */           if (paramInt2 > 0) {
/* 1622 */             if (paramInt1 >= paramContext.limit)
/* 1623 */               return -1; 
/* 1624 */             char c = str.charAt(paramInt1);
/* 1625 */             if (isSet(paramInt3, 4)) {
/* 1626 */               if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/* 1627 */                 paramInt1++; 
/*      */             } else {
/* 1629 */               int n; if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/* 1630 */                 n = REUtil.composeFromSurrogates(c, str.charAt(++paramInt1)); 
/* 1631 */               if (isEOLChar(n))
/* 1632 */                 return -1; 
/*      */             } 
/* 1634 */             paramInt1++;
/*      */           } else {
/* 1636 */             int n = paramInt1 - 1;
/* 1637 */             if (n >= paramContext.limit || n < 0)
/* 1638 */               return -1; 
/* 1639 */             char c = str.charAt(n);
/* 1640 */             if (isSet(paramInt3, 4)) {
/* 1641 */               if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/* 1642 */                 n--; 
/*      */             } else {
/* 1644 */               int i1; if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/* 1645 */                 i1 = REUtil.composeFromSurrogates(str.charAt(--n), c); 
/* 1646 */               if (!isEOLChar(i1))
/* 1647 */                 return -1; 
/*      */             } 
/* 1649 */             paramInt1 = n;
/*      */           } 
/* 1651 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 3:
/*      */         case 4:
/* 1656 */           if (paramInt2 > 0) {
/* 1657 */             if (paramInt1 >= paramContext.limit)
/* 1658 */               return -1; 
/* 1659 */             int n = str.charAt(paramInt1);
/* 1660 */             if (REUtil.isHighSurrogate(n) && paramInt1 + 1 < paramContext.limit)
/* 1661 */               n = REUtil.composeFromSurrogates(n, str.charAt(++paramInt1)); 
/* 1662 */             RangeToken rangeToken = paramOp.getToken();
/* 1663 */             if (isSet(paramInt3, 2))
/* 1664 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/* 1665 */               if (!rangeToken.match(n)) {
/* 1666 */                 if (n >= 65536) return -1; 
/*      */                 char c;
/* 1668 */                 if (!rangeToken.match(c = Character.toUpperCase((char)n)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/* 1670 */                   return -1;
/*      */                 }
/*      */               }  }
/* 1673 */             else if (!rangeToken.match(n)) { return -1; }
/*      */             
/* 1675 */             paramInt1++;
/*      */           } else {
/* 1677 */             int n = paramInt1 - 1;
/* 1678 */             if (n >= paramContext.limit || n < 0)
/* 1679 */               return -1; 
/* 1680 */             int i1 = str.charAt(n);
/* 1681 */             if (REUtil.isLowSurrogate(i1) && n - 1 >= 0)
/* 1682 */               i1 = REUtil.composeFromSurrogates(str.charAt(--n), i1); 
/* 1683 */             RangeToken rangeToken = paramOp.getToken();
/* 1684 */             if (isSet(paramInt3, 2))
/* 1685 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/* 1686 */               if (!rangeToken.match(i1)) {
/* 1687 */                 if (i1 >= 65536) return -1; 
/*      */                 char c;
/* 1689 */                 if (!rangeToken.match(c = Character.toUpperCase((char)i1)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/* 1691 */                   return -1;
/*      */                 }
/*      */               }  }
/* 1694 */             else if (!rangeToken.match(i1)) { return -1; }
/*      */             
/* 1696 */             paramInt1 = n;
/*      */           } 
/* 1698 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 5:
/* 1702 */           bool = false;
/* 1703 */           switch (paramOp.getData()) {
/*      */             case 94:
/* 1705 */               if (isSet(paramInt3, 8)) {
/* 1706 */                 if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(str.charAt(paramInt1 - 1))))
/*      */                 {
/* 1708 */                   return -1; }  break;
/*      */               } 
/* 1710 */               if (paramInt1 != paramContext.start) {
/* 1711 */                 return -1;
/*      */               }
/*      */               break;
/*      */ 
/*      */             
/*      */             case 64:
/* 1717 */               if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(str.charAt(paramInt1 - 1))))
/*      */               {
/* 1719 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 36:
/* 1723 */               if (isSet(paramInt3, 8)) {
/* 1724 */                 if (paramInt1 != paramContext.limit && (paramInt1 >= paramContext.limit || !isEOLChar(str.charAt(paramInt1))))
/*      */                 {
/* 1726 */                   return -1; }  break;
/*      */               } 
/* 1728 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(str.charAt(paramInt1))) && (paramInt1 + 2 != paramContext.limit || str.charAt(paramInt1) != '\r' || str.charAt(paramInt1 + 1) != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 1732 */                 return -1;
/*      */               }
/*      */               break;
/*      */             
/*      */             case 65:
/* 1737 */               if (paramInt1 != paramContext.start) return -1;
/*      */               
/*      */               break;
/*      */             case 90:
/* 1741 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(str.charAt(paramInt1))) && (paramInt1 + 2 != paramContext.limit || str.charAt(paramInt1) != '\r' || str.charAt(paramInt1 + 1) != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 1745 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 122:
/* 1749 */               if (paramInt1 != paramContext.limit) return -1;
/*      */               
/*      */               break;
/*      */             case 98:
/* 1753 */               if (paramContext.length == 0) return -1;
/*      */               
/* 1755 */               j = getWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1756 */               if (j == 0) return -1; 
/* 1757 */               k = getPreviousWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1758 */               if (j == k) return -1;
/*      */               
/*      */               break;
/*      */             
/*      */             case 66:
/* 1763 */               if (paramContext.length == 0) {
/* 1764 */                 bool = true;
/*      */               } else {
/* 1766 */                 j = getWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 1767 */                 bool = (j == 0 || j == getPreviousWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3)) ? true : false;
/*      */               } 
/*      */               
/* 1770 */               if (!bool) return -1;
/*      */               
/*      */               break;
/*      */             case 60:
/* 1774 */               if (paramContext.length == 0 || paramInt1 == paramContext.limit) return -1; 
/* 1775 */               if (getWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1 || getPreviousWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2)
/*      */               {
/* 1777 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 62:
/* 1781 */               if (paramContext.length == 0 || paramInt1 == paramContext.start) return -1; 
/* 1782 */               if (getWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2 || getPreviousWordType(str, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1)
/*      */               {
/* 1784 */                 return -1; } 
/*      */               break;
/*      */           } 
/* 1787 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 16:
/* 1792 */           j = paramOp.getData();
/* 1793 */           if (j <= 0 || j >= this.nofparen)
/* 1794 */             throw new RuntimeException("Internal Error: Reference number must be more than zero: " + j); 
/* 1795 */           if (paramContext.match.getBeginning(j) < 0 || paramContext.match.getEnd(j) < 0)
/*      */           {
/* 1797 */             return -1; } 
/* 1798 */           k = paramContext.match.getBeginning(j);
/* 1799 */           m = paramContext.match.getEnd(j) - k;
/* 1800 */           if (!isSet(paramInt3, 2)) {
/* 1801 */             if (paramInt2 > 0) {
/* 1802 */               if (!regionMatches(str, paramInt1, paramContext.limit, k, m))
/* 1803 */                 return -1; 
/* 1804 */               paramInt1 += m;
/*      */             } else {
/* 1806 */               if (!regionMatches(str, paramInt1 - m, paramContext.limit, k, m))
/* 1807 */                 return -1; 
/* 1808 */               paramInt1 -= m;
/*      */             }
/*      */           
/* 1811 */           } else if (paramInt2 > 0) {
/* 1812 */             if (!regionMatchesIgnoreCase(str, paramInt1, paramContext.limit, k, m))
/* 1813 */               return -1; 
/* 1814 */             paramInt1 += m;
/*      */           } else {
/* 1816 */             if (!regionMatchesIgnoreCase(str, paramInt1 - m, paramContext.limit, k, m))
/*      */             {
/* 1818 */               return -1; } 
/* 1819 */             paramInt1 -= m;
/*      */           } 
/*      */ 
/*      */           
/* 1823 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 6:
/* 1827 */           str1 = paramOp.getString();
/* 1828 */           k = str1.length();
/* 1829 */           if (!isSet(paramInt3, 2)) {
/* 1830 */             if (paramInt2 > 0) {
/* 1831 */               if (!regionMatches(str, paramInt1, paramContext.limit, str1, k))
/* 1832 */                 return -1; 
/* 1833 */               paramInt1 += k;
/*      */             } else {
/* 1835 */               if (!regionMatches(str, paramInt1 - k, paramContext.limit, str1, k))
/* 1836 */                 return -1; 
/* 1837 */               paramInt1 -= k;
/*      */             }
/*      */           
/* 1840 */           } else if (paramInt2 > 0) {
/* 1841 */             if (!regionMatchesIgnoreCase(str, paramInt1, paramContext.limit, str1, k))
/* 1842 */               return -1; 
/* 1843 */             paramInt1 += k;
/*      */           } else {
/* 1845 */             if (!regionMatchesIgnoreCase(str, paramInt1 - k, paramContext.limit, str1, k))
/*      */             {
/* 1847 */               return -1; } 
/* 1848 */             paramInt1 -= k;
/*      */           } 
/*      */ 
/*      */           
/* 1852 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 7:
/* 1861 */           i = paramOp.getData();
/* 1862 */           if (i >= 0) {
/* 1863 */             k = paramContext.offsets[i];
/* 1864 */             if (k < 0 || k != paramInt1) {
/* 1865 */               paramContext.offsets[i] = paramInt1;
/*      */             } else {
/* 1867 */               paramContext.offsets[i] = -1;
/* 1868 */               paramOp = paramOp.next;
/*      */               continue;
/*      */             } 
/*      */           } 
/* 1872 */           k = matchString(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1873 */           if (i >= 0) paramContext.offsets[i] = -1; 
/* 1874 */           if (k >= 0) return k; 
/* 1875 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 9:
/* 1881 */           i = matchString(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1882 */           if (i >= 0) return i; 
/* 1883 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 8:
/*      */         case 10:
/* 1890 */           i = matchString(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1891 */           if (i >= 0) return i; 
/* 1892 */           paramOp = paramOp.getChild();
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 11:
/* 1897 */           for (i = 0; i < paramOp.size(); i++) {
/* 1898 */             k = matchString(paramContext, paramOp.elementAt(i), paramInt1, paramInt2, paramInt3);
/*      */ 
/*      */ 
/*      */             
/* 1902 */             if (k >= 0) return k; 
/*      */           } 
/* 1904 */           return -1;
/*      */         
/*      */         case 15:
/* 1907 */           i = paramOp.getData();
/* 1908 */           if (paramContext.match != null && i > 0) {
/* 1909 */             k = paramContext.match.getBeginning(i);
/* 1910 */             paramContext.match.setBeginning(i, paramInt1);
/* 1911 */             m = matchString(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1912 */             if (m < 0) paramContext.match.setBeginning(i, k); 
/* 1913 */             return m;
/* 1914 */           }  if (paramContext.match != null && i < 0) {
/* 1915 */             k = -i;
/* 1916 */             m = paramContext.match.getEnd(k);
/* 1917 */             paramContext.match.setEnd(k, paramInt1);
/* 1918 */             int n = matchString(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 1919 */             if (n < 0) paramContext.match.setEnd(k, m); 
/* 1920 */             return n;
/*      */           } 
/* 1922 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 20:
/* 1926 */           if (0 > matchString(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 1927 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 21:
/* 1930 */           if (0 <= matchString(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 1931 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 22:
/* 1934 */           if (0 > matchString(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 1935 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 23:
/* 1938 */           if (0 <= matchString(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 1939 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 24:
/* 1944 */           k = matchString(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 1945 */           if (k < 0) return k; 
/* 1946 */           paramInt1 = k;
/* 1947 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 25:
/* 1953 */           k = paramInt3;
/* 1954 */           k |= paramOp.getData();
/* 1955 */           k &= paramOp.getData2() ^ 0xFFFFFFFF;
/*      */           
/* 1957 */           m = matchString(paramContext, paramOp.getChild(), paramInt1, paramInt2, k);
/* 1958 */           if (m < 0) return m; 
/* 1959 */           paramInt1 = m;
/* 1960 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 26:
/* 1966 */           conditionOp = (Op.ConditionOp)paramOp;
/* 1967 */           m = 0;
/* 1968 */           if (conditionOp.refNumber > 0) {
/* 1969 */             if (conditionOp.refNumber >= this.nofparen)
/* 1970 */               throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber); 
/* 1971 */             m = (paramContext.match.getBeginning(conditionOp.refNumber) >= 0 && paramContext.match.getEnd(conditionOp.refNumber) >= 0) ? 1 : 0;
/*      */           } else {
/*      */             
/* 1974 */             m = (0 <= matchString(paramContext, conditionOp.condition, paramInt1, paramInt2, paramInt3)) ? 1 : 0;
/*      */           } 
/*      */           
/* 1977 */           if (m != 0) {
/* 1978 */             paramOp = conditionOp.yes; continue;
/* 1979 */           }  if (conditionOp.no != null) {
/* 1980 */             paramOp = conditionOp.no; continue;
/*      */           } 
/* 1982 */           paramOp = conditionOp.next;
/*      */           continue;
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/* 1988 */     throw new RuntimeException("Unknown operation type: " + paramOp.type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int getPreviousWordType(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1995 */     int i = getWordType(paramString, paramInt1, paramInt2, --paramInt3, paramInt4);
/* 1996 */     while (i == 0)
/* 1997 */       i = getWordType(paramString, paramInt1, paramInt2, --paramInt3, paramInt4); 
/* 1998 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int getWordType(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2003 */     if (paramInt3 < paramInt1 || paramInt3 >= paramInt2) return 2; 
/* 2004 */     return getWordType0(paramString.charAt(paramInt3), paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3) {
/* 2010 */     if (paramInt2 - paramInt1 < paramInt3) return false; 
/* 2011 */     return paramString1.regionMatches(paramInt1, paramString2, 0, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2016 */     if (paramInt2 - paramInt1 < paramInt4) return false; 
/* 2017 */     return paramString.regionMatches(paramInt1, paramString, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3) {
/* 2022 */     return paramString1.regionMatches(true, paramInt1, paramString2, 0, paramInt3);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2027 */     if (paramInt2 - paramInt1 < paramInt4) return false; 
/* 2028 */     return paramString.regionMatches(true, paramInt1, paramString, paramInt3, paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(CharacterIterator paramCharacterIterator) {
/* 2043 */     return matches(paramCharacterIterator, (Match)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean matches(CharacterIterator paramCharacterIterator, Match paramMatch) {
/* 2054 */     int m, i = paramCharacterIterator.getBeginIndex();
/* 2055 */     int j = paramCharacterIterator.getEndIndex();
/*      */ 
/*      */ 
/*      */     
/* 2059 */     synchronized (this) {
/* 2060 */       if (this.operations == null)
/* 2061 */         prepare(); 
/* 2062 */       if (this.context == null)
/* 2063 */         this.context = new Context(); 
/*      */     } 
/* 2065 */     Context context = null;
/* 2066 */     synchronized (this.context) {
/* 2067 */       context = this.context.inuse ? new Context() : this.context;
/* 2068 */       context.reset(paramCharacterIterator, i, j, this.numberOfClosures);
/*      */     } 
/* 2070 */     if (paramMatch != null) {
/* 2071 */       paramMatch.setNumberOfGroups(this.nofparen);
/* 2072 */       paramMatch.setSource(paramCharacterIterator);
/* 2073 */     } else if (this.hasBackReferences) {
/* 2074 */       paramMatch = new Match();
/* 2075 */       paramMatch.setNumberOfGroups(this.nofparen);
/*      */     } 
/*      */ 
/*      */     
/* 2079 */     context.match = paramMatch;
/*      */     
/* 2081 */     if (isSet(this.options, 512)) {
/* 2082 */       int i1 = matchCharacterIterator(context, this.operations, context.start, 1, this.options);
/*      */       
/* 2084 */       if (i1 == context.limit) {
/* 2085 */         if (context.match != null) {
/* 2086 */           context.match.setBeginning(0, context.start);
/* 2087 */           context.match.setEnd(0, i1);
/*      */         } 
/* 2089 */         context.inuse = false;
/* 2090 */         return true;
/*      */       } 
/* 2092 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2099 */     if (this.fixedStringOnly) {
/*      */       
/* 2101 */       int i1 = this.fixedStringTable.matches(paramCharacterIterator, context.start, context.limit);
/* 2102 */       if (i1 >= 0) {
/* 2103 */         if (context.match != null) {
/* 2104 */           context.match.setBeginning(0, i1);
/* 2105 */           context.match.setEnd(0, i1 + this.fixedString.length());
/*      */         } 
/* 2107 */         context.inuse = false;
/* 2108 */         return true;
/*      */       } 
/* 2110 */       context.inuse = false;
/* 2111 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2119 */     if (this.fixedString != null) {
/* 2120 */       int i1 = this.fixedStringTable.matches(paramCharacterIterator, context.start, context.limit);
/* 2121 */       if (i1 < 0) {
/*      */         
/* 2123 */         context.inuse = false;
/* 2124 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/* 2128 */     int k = context.limit - this.minlength;
/*      */     
/* 2130 */     int n = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2135 */     if (this.operations != null && this.operations.type == 7 && (this.operations.getChild()).type == 0) {
/*      */       
/* 2137 */       if (isSet(this.options, 4)) {
/* 2138 */         m = context.start;
/* 2139 */         n = matchCharacterIterator(context, this.operations, context.start, 1, this.options);
/*      */       } else {
/* 2141 */         boolean bool = true;
/* 2142 */         for (m = context.start; m <= k; m++) {
/* 2143 */           char c = paramCharacterIterator.setIndex(m);
/* 2144 */           if (isEOLChar(c)) {
/* 2145 */             bool = true;
/*      */           } else {
/* 2147 */             if (bool && 
/* 2148 */               0 <= (n = matchCharacterIterator(context, this.operations, m, 1, this.options))) {
/*      */               break;
/*      */             }
/*      */             
/* 2152 */             bool = false;
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/* 2161 */     else if (this.firstChar != null) {
/*      */       
/* 2163 */       RangeToken rangeToken = this.firstChar;
/* 2164 */       if (isSet(this.options, 2)) {
/* 2165 */         rangeToken = this.firstChar.getCaseInsensitiveToken();
/* 2166 */         for (m = context.start; m <= k; m++) {
/* 2167 */           int i1 = paramCharacterIterator.setIndex(m);
/* 2168 */           if (REUtil.isHighSurrogate(i1) && m + 1 < context.limit) {
/* 2169 */             i1 = REUtil.composeFromSurrogates(i1, paramCharacterIterator.setIndex(m + 1));
/* 2170 */             if (!rangeToken.match(i1))
/*      */               continue; 
/* 2172 */           } else if (!rangeToken.match(i1)) {
/* 2173 */             char c = Character.toUpperCase((char)i1);
/* 2174 */             if (!rangeToken.match(c) && 
/* 2175 */               !rangeToken.match(Character.toLowerCase(c))) {
/*      */               continue;
/*      */             }
/*      */           } 
/* 2179 */           if (0 <= (n = matchCharacterIterator(context, this.operations, m, 1, this.options)))
/*      */             break; 
/*      */           continue;
/*      */         } 
/*      */       } else {
/* 2184 */         for (m = context.start; m <= k; m++) {
/* 2185 */           int i1 = paramCharacterIterator.setIndex(m);
/* 2186 */           if (REUtil.isHighSurrogate(i1) && m + 1 < context.limit)
/* 2187 */             i1 = REUtil.composeFromSurrogates(i1, paramCharacterIterator.setIndex(m + 1)); 
/* 2188 */           if (rangeToken.match(i1) && 
/* 2189 */             0 <= (n = matchCharacterIterator(context, this.operations, m, 1, this.options)))
/*      */           {
/*      */             break;
/*      */           }
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 2200 */       for (m = context.start; m <= k && 
/* 2201 */         0 > (n = matchCharacterIterator(context, this.operations, m, 1, this.options)); m++);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2206 */     if (n >= 0) {
/* 2207 */       if (context.match != null) {
/* 2208 */         context.match.setBeginning(0, m);
/* 2209 */         context.match.setEnd(0, n);
/*      */       } 
/* 2211 */       context.inuse = false;
/* 2212 */       return true;
/*      */     } 
/* 2214 */     context.inuse = false;
/* 2215 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int matchCharacterIterator(Context paramContext, Op paramOp, int paramInt1, int paramInt2, int paramInt3) {
/* 2225 */     CharacterIterator characterIterator = paramContext.ciTarget; while (true) {
/*      */       boolean bool;
/*      */       int j;
/*      */       String str;
/*      */       int i;
/*      */       int k;
/*      */       Op.ConditionOp conditionOp;
/*      */       int m;
/* 2233 */       if (paramOp == null)
/* 2234 */         return (isSet(paramInt3, 512) && paramInt1 != paramContext.limit) ? -1 : paramInt1; 
/* 2235 */       if (paramInt1 > paramContext.limit || paramInt1 < paramContext.start)
/* 2236 */         return -1; 
/* 2237 */       switch (paramOp.type) {
/*      */         case 1:
/* 2239 */           if (isSet(paramInt3, 2)) {
/* 2240 */             int n = paramOp.getData();
/* 2241 */             if (paramInt2 > 0) {
/* 2242 */               if (paramInt1 >= paramContext.limit || !matchIgnoreCase(n, characterIterator.setIndex(paramInt1)))
/* 2243 */                 return -1; 
/* 2244 */               paramInt1++;
/*      */             } else {
/* 2246 */               int i1 = paramInt1 - 1;
/* 2247 */               if (i1 >= paramContext.limit || i1 < 0 || !matchIgnoreCase(n, characterIterator.setIndex(i1)))
/* 2248 */                 return -1; 
/* 2249 */               paramInt1 = i1;
/*      */             } 
/*      */           } else {
/* 2252 */             int n = paramOp.getData();
/* 2253 */             if (paramInt2 > 0) {
/* 2254 */               if (paramInt1 >= paramContext.limit || n != characterIterator.setIndex(paramInt1))
/* 2255 */                 return -1; 
/* 2256 */               paramInt1++;
/*      */             } else {
/* 2258 */               int i1 = paramInt1 - 1;
/* 2259 */               if (i1 >= paramContext.limit || i1 < 0 || n != characterIterator.setIndex(i1))
/* 2260 */                 return -1; 
/* 2261 */               paramInt1 = i1;
/*      */             } 
/*      */           } 
/* 2264 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 0:
/* 2268 */           if (paramInt2 > 0) {
/* 2269 */             if (paramInt1 >= paramContext.limit)
/* 2270 */               return -1; 
/* 2271 */             char c = characterIterator.setIndex(paramInt1);
/* 2272 */             if (isSet(paramInt3, 4)) {
/* 2273 */               if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/* 2274 */                 paramInt1++; 
/*      */             } else {
/* 2276 */               int n; if (REUtil.isHighSurrogate(c) && paramInt1 + 1 < paramContext.limit)
/* 2277 */                 n = REUtil.composeFromSurrogates(c, characterIterator.setIndex(++paramInt1)); 
/* 2278 */               if (isEOLChar(n))
/* 2279 */                 return -1; 
/*      */             } 
/* 2281 */             paramInt1++;
/*      */           } else {
/* 2283 */             int n = paramInt1 - 1;
/* 2284 */             if (n >= paramContext.limit || n < 0)
/* 2285 */               return -1; 
/* 2286 */             char c = characterIterator.setIndex(n);
/* 2287 */             if (isSet(paramInt3, 4)) {
/* 2288 */               if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/* 2289 */                 n--; 
/*      */             } else {
/* 2291 */               int i1; if (REUtil.isLowSurrogate(c) && n - 1 >= 0)
/* 2292 */                 i1 = REUtil.composeFromSurrogates(characterIterator.setIndex(--n), c); 
/* 2293 */               if (!isEOLChar(i1))
/* 2294 */                 return -1; 
/*      */             } 
/* 2296 */             paramInt1 = n;
/*      */           } 
/* 2298 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 3:
/*      */         case 4:
/* 2303 */           if (paramInt2 > 0) {
/* 2304 */             if (paramInt1 >= paramContext.limit)
/* 2305 */               return -1; 
/* 2306 */             int n = characterIterator.setIndex(paramInt1);
/* 2307 */             if (REUtil.isHighSurrogate(n) && paramInt1 + 1 < paramContext.limit)
/* 2308 */               n = REUtil.composeFromSurrogates(n, characterIterator.setIndex(++paramInt1)); 
/* 2309 */             RangeToken rangeToken = paramOp.getToken();
/* 2310 */             if (isSet(paramInt3, 2))
/* 2311 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/* 2312 */               if (!rangeToken.match(n)) {
/* 2313 */                 if (n >= 65536) return -1; 
/*      */                 char c;
/* 2315 */                 if (!rangeToken.match(c = Character.toUpperCase((char)n)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/* 2317 */                   return -1;
/*      */                 }
/*      */               }  }
/* 2320 */             else if (!rangeToken.match(n)) { return -1; }
/*      */             
/* 2322 */             paramInt1++;
/*      */           } else {
/* 2324 */             int n = paramInt1 - 1;
/* 2325 */             if (n >= paramContext.limit || n < 0)
/* 2326 */               return -1; 
/* 2327 */             int i1 = characterIterator.setIndex(n);
/* 2328 */             if (REUtil.isLowSurrogate(i1) && n - 1 >= 0)
/* 2329 */               i1 = REUtil.composeFromSurrogates(characterIterator.setIndex(--n), i1); 
/* 2330 */             RangeToken rangeToken = paramOp.getToken();
/* 2331 */             if (isSet(paramInt3, 2))
/* 2332 */             { rangeToken = rangeToken.getCaseInsensitiveToken();
/* 2333 */               if (!rangeToken.match(i1)) {
/* 2334 */                 if (i1 >= 65536) return -1; 
/*      */                 char c;
/* 2336 */                 if (!rangeToken.match(c = Character.toUpperCase((char)i1)) && !rangeToken.match(Character.toLowerCase(c)))
/*      */                 {
/* 2338 */                   return -1;
/*      */                 }
/*      */               }  }
/* 2341 */             else if (!rangeToken.match(i1)) { return -1; }
/*      */             
/* 2343 */             paramInt1 = n;
/*      */           } 
/* 2345 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 5:
/* 2349 */           bool = false;
/* 2350 */           switch (paramOp.getData()) {
/*      */             case 94:
/* 2352 */               if (isSet(paramInt3, 8)) {
/* 2353 */                 if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(characterIterator.setIndex(paramInt1 - 1))))
/*      */                 {
/* 2355 */                   return -1; }  break;
/*      */               } 
/* 2357 */               if (paramInt1 != paramContext.start) {
/* 2358 */                 return -1;
/*      */               }
/*      */               break;
/*      */ 
/*      */             
/*      */             case 64:
/* 2364 */               if (paramInt1 != paramContext.start && (paramInt1 <= paramContext.start || !isEOLChar(characterIterator.setIndex(paramInt1 - 1))))
/*      */               {
/* 2366 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 36:
/* 2370 */               if (isSet(paramInt3, 8)) {
/* 2371 */                 if (paramInt1 != paramContext.limit && (paramInt1 >= paramContext.limit || !isEOLChar(characterIterator.setIndex(paramInt1))))
/*      */                 {
/* 2373 */                   return -1; }  break;
/*      */               } 
/* 2375 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(characterIterator.setIndex(paramInt1))) && (paramInt1 + 2 != paramContext.limit || characterIterator.setIndex(paramInt1) != '\r' || characterIterator.setIndex(paramInt1 + 1) != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 2379 */                 return -1;
/*      */               }
/*      */               break;
/*      */             
/*      */             case 65:
/* 2384 */               if (paramInt1 != paramContext.start) return -1;
/*      */               
/*      */               break;
/*      */             case 90:
/* 2388 */               if (paramInt1 != paramContext.limit && (paramInt1 + 1 != paramContext.limit || !isEOLChar(characterIterator.setIndex(paramInt1))) && (paramInt1 + 2 != paramContext.limit || characterIterator.setIndex(paramInt1) != '\r' || characterIterator.setIndex(paramInt1 + 1) != '\n'))
/*      */               {
/*      */ 
/*      */                 
/* 2392 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 122:
/* 2396 */               if (paramInt1 != paramContext.limit) return -1;
/*      */               
/*      */               break;
/*      */             case 98:
/* 2400 */               if (paramContext.length == 0) return -1;
/*      */               
/* 2402 */               j = getWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 2403 */               if (j == 0) return -1; 
/* 2404 */               k = getPreviousWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 2405 */               if (j == k) return -1;
/*      */               
/*      */               break;
/*      */             
/*      */             case 66:
/* 2410 */               if (paramContext.length == 0) {
/* 2411 */                 bool = true;
/*      */               } else {
/* 2413 */                 j = getWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3);
/* 2414 */                 bool = (j == 0 || j == getPreviousWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3)) ? true : false;
/*      */               } 
/*      */               
/* 2417 */               if (!bool) return -1;
/*      */               
/*      */               break;
/*      */             case 60:
/* 2421 */               if (paramContext.length == 0 || paramInt1 == paramContext.limit) return -1; 
/* 2422 */               if (getWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1 || getPreviousWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2)
/*      */               {
/* 2424 */                 return -1;
/*      */               }
/*      */               break;
/*      */             case 62:
/* 2428 */               if (paramContext.length == 0 || paramInt1 == paramContext.start) return -1; 
/* 2429 */               if (getWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 2 || getPreviousWordType(characterIterator, paramContext.start, paramContext.limit, paramInt1, paramInt3) != 1)
/*      */               {
/* 2431 */                 return -1; } 
/*      */               break;
/*      */           } 
/* 2434 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 16:
/* 2439 */           j = paramOp.getData();
/* 2440 */           if (j <= 0 || j >= this.nofparen)
/* 2441 */             throw new RuntimeException("Internal Error: Reference number must be more than zero: " + j); 
/* 2442 */           if (paramContext.match.getBeginning(j) < 0 || paramContext.match.getEnd(j) < 0)
/*      */           {
/* 2444 */             return -1; } 
/* 2445 */           k = paramContext.match.getBeginning(j);
/* 2446 */           m = paramContext.match.getEnd(j) - k;
/* 2447 */           if (!isSet(paramInt3, 2)) {
/* 2448 */             if (paramInt2 > 0) {
/* 2449 */               if (!regionMatches(characterIterator, paramInt1, paramContext.limit, k, m))
/* 2450 */                 return -1; 
/* 2451 */               paramInt1 += m;
/*      */             } else {
/* 2453 */               if (!regionMatches(characterIterator, paramInt1 - m, paramContext.limit, k, m))
/* 2454 */                 return -1; 
/* 2455 */               paramInt1 -= m;
/*      */             }
/*      */           
/* 2458 */           } else if (paramInt2 > 0) {
/* 2459 */             if (!regionMatchesIgnoreCase(characterIterator, paramInt1, paramContext.limit, k, m))
/* 2460 */               return -1; 
/* 2461 */             paramInt1 += m;
/*      */           } else {
/* 2463 */             if (!regionMatchesIgnoreCase(characterIterator, paramInt1 - m, paramContext.limit, k, m))
/*      */             {
/* 2465 */               return -1; } 
/* 2466 */             paramInt1 -= m;
/*      */           } 
/*      */ 
/*      */           
/* 2470 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 6:
/* 2474 */           str = paramOp.getString();
/* 2475 */           k = str.length();
/* 2476 */           if (!isSet(paramInt3, 2)) {
/* 2477 */             if (paramInt2 > 0) {
/* 2478 */               if (!regionMatches(characterIterator, paramInt1, paramContext.limit, str, k))
/* 2479 */                 return -1; 
/* 2480 */               paramInt1 += k;
/*      */             } else {
/* 2482 */               if (!regionMatches(characterIterator, paramInt1 - k, paramContext.limit, str, k))
/* 2483 */                 return -1; 
/* 2484 */               paramInt1 -= k;
/*      */             }
/*      */           
/* 2487 */           } else if (paramInt2 > 0) {
/* 2488 */             if (!regionMatchesIgnoreCase(characterIterator, paramInt1, paramContext.limit, str, k))
/* 2489 */               return -1; 
/* 2490 */             paramInt1 += k;
/*      */           } else {
/* 2492 */             if (!regionMatchesIgnoreCase(characterIterator, paramInt1 - k, paramContext.limit, str, k))
/*      */             {
/* 2494 */               return -1; } 
/* 2495 */             paramInt1 -= k;
/*      */           } 
/*      */ 
/*      */           
/* 2499 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 7:
/* 2508 */           i = paramOp.getData();
/* 2509 */           if (i >= 0) {
/* 2510 */             k = paramContext.offsets[i];
/* 2511 */             if (k < 0 || k != paramInt1) {
/* 2512 */               paramContext.offsets[i] = paramInt1;
/*      */             } else {
/* 2514 */               paramContext.offsets[i] = -1;
/* 2515 */               paramOp = paramOp.next;
/*      */               
/*      */               continue;
/*      */             } 
/*      */           } 
/* 2520 */           k = matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 2521 */           if (i >= 0) paramContext.offsets[i] = -1; 
/* 2522 */           if (k >= 0) return k; 
/* 2523 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 9:
/* 2529 */           i = matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 2530 */           if (i >= 0) return i; 
/* 2531 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 8:
/*      */         case 10:
/* 2538 */           i = matchCharacterIterator(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 2539 */           if (i >= 0) return i; 
/* 2540 */           paramOp = paramOp.getChild();
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 11:
/* 2545 */           for (i = 0; i < paramOp.size(); i++) {
/* 2546 */             k = matchCharacterIterator(paramContext, paramOp.elementAt(i), paramInt1, paramInt2, paramInt3);
/*      */ 
/*      */ 
/*      */             
/* 2550 */             if (k >= 0) return k; 
/*      */           } 
/* 2552 */           return -1;
/*      */         
/*      */         case 15:
/* 2555 */           i = paramOp.getData();
/* 2556 */           if (paramContext.match != null && i > 0) {
/* 2557 */             k = paramContext.match.getBeginning(i);
/* 2558 */             paramContext.match.setBeginning(i, paramInt1);
/* 2559 */             m = matchCharacterIterator(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 2560 */             if (m < 0) paramContext.match.setBeginning(i, k); 
/* 2561 */             return m;
/* 2562 */           }  if (paramContext.match != null && i < 0) {
/* 2563 */             k = -i;
/* 2564 */             m = paramContext.match.getEnd(k);
/* 2565 */             paramContext.match.setEnd(k, paramInt1);
/* 2566 */             int n = matchCharacterIterator(paramContext, paramOp.next, paramInt1, paramInt2, paramInt3);
/* 2567 */             if (n < 0) paramContext.match.setEnd(k, m); 
/* 2568 */             return n;
/*      */           } 
/* 2570 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         
/*      */         case 20:
/* 2574 */           if (0 > matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 2575 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 21:
/* 2578 */           if (0 <= matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, 1, paramInt3)) return -1; 
/* 2579 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 22:
/* 2582 */           if (0 > matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 2583 */           paramOp = paramOp.next;
/*      */           continue;
/*      */         case 23:
/* 2586 */           if (0 <= matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, -1, paramInt3)) return -1; 
/* 2587 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */         
/*      */         case 24:
/* 2592 */           k = matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, paramInt2, paramInt3);
/* 2593 */           if (k < 0) return k; 
/* 2594 */           paramInt1 = k;
/* 2595 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 25:
/* 2601 */           k = paramInt3;
/* 2602 */           k |= paramOp.getData();
/* 2603 */           k &= paramOp.getData2() ^ 0xFFFFFFFF;
/*      */           
/* 2605 */           m = matchCharacterIterator(paramContext, paramOp.getChild(), paramInt1, paramInt2, k);
/* 2606 */           if (m < 0) return m; 
/* 2607 */           paramInt1 = m;
/* 2608 */           paramOp = paramOp.next;
/*      */           continue;
/*      */ 
/*      */ 
/*      */         
/*      */         case 26:
/* 2614 */           conditionOp = (Op.ConditionOp)paramOp;
/* 2615 */           m = 0;
/* 2616 */           if (conditionOp.refNumber > 0) {
/* 2617 */             if (conditionOp.refNumber >= this.nofparen)
/* 2618 */               throw new RuntimeException("Internal Error: Reference number must be more than zero: " + conditionOp.refNumber); 
/* 2619 */             m = (paramContext.match.getBeginning(conditionOp.refNumber) >= 0 && paramContext.match.getEnd(conditionOp.refNumber) >= 0) ? 1 : 0;
/*      */           } else {
/*      */             
/* 2622 */             m = (0 <= matchCharacterIterator(paramContext, conditionOp.condition, paramInt1, paramInt2, paramInt3)) ? 1 : 0;
/*      */           } 
/*      */           
/* 2625 */           if (m != 0) {
/* 2626 */             paramOp = conditionOp.yes; continue;
/* 2627 */           }  if (conditionOp.no != null) {
/* 2628 */             paramOp = conditionOp.no; continue;
/*      */           } 
/* 2630 */           paramOp = conditionOp.next;
/*      */           continue;
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/* 2636 */     throw new RuntimeException("Unknown operation type: " + paramOp.type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int getPreviousWordType(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2643 */     int i = getWordType(paramCharacterIterator, paramInt1, paramInt2, --paramInt3, paramInt4);
/* 2644 */     while (i == 0)
/* 2645 */       i = getWordType(paramCharacterIterator, paramInt1, paramInt2, --paramInt3, paramInt4); 
/* 2646 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int getWordType(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2651 */     if (paramInt3 < paramInt1 || paramInt3 >= paramInt2) return 2; 
/* 2652 */     return getWordType0(paramCharacterIterator.setIndex(paramInt3), paramInt4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/* 2659 */     if (paramInt1 < 0) return false; 
/* 2660 */     if (paramInt2 - paramInt1 < paramInt3)
/* 2661 */       return false; 
/* 2662 */     byte b = 0;
/* 2663 */     while (paramInt3-- > 0) {
/* 2664 */       if (paramCharacterIterator.setIndex(paramInt1++) != paramString.charAt(b++))
/* 2665 */         return false; 
/*      */     } 
/* 2667 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatches(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2672 */     if (paramInt1 < 0) return false; 
/* 2673 */     if (paramInt2 - paramInt1 < paramInt4)
/* 2674 */       return false; 
/* 2675 */     int i = paramInt3;
/* 2676 */     while (paramInt4-- > 0) {
/* 2677 */       if (paramCharacterIterator.setIndex(paramInt1++) != paramCharacterIterator.setIndex(i++))
/* 2678 */         return false; 
/*      */     } 
/* 2680 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/* 2688 */     if (paramInt1 < 0) return false; 
/* 2689 */     if (paramInt2 - paramInt1 < paramInt3)
/* 2690 */       return false; 
/* 2691 */     byte b = 0;
/* 2692 */     while (paramInt3-- > 0) {
/* 2693 */       char c1 = paramCharacterIterator.setIndex(paramInt1++);
/* 2694 */       char c2 = paramString.charAt(b++);
/* 2695 */       if (c1 == c2)
/*      */         continue; 
/* 2697 */       char c3 = Character.toUpperCase(c1);
/* 2698 */       char c4 = Character.toUpperCase(c2);
/* 2699 */       if (c3 == c4)
/*      */         continue; 
/* 2701 */       if (Character.toLowerCase(c3) != Character.toLowerCase(c4))
/* 2702 */         return false; 
/*      */     } 
/* 2704 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean regionMatchesIgnoreCase(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2709 */     if (paramInt1 < 0) return false; 
/* 2710 */     if (paramInt2 - paramInt1 < paramInt4)
/* 2711 */       return false; 
/* 2712 */     int i = paramInt3;
/* 2713 */     while (paramInt4-- > 0) {
/* 2714 */       char c1 = paramCharacterIterator.setIndex(paramInt1++);
/* 2715 */       char c2 = paramCharacterIterator.setIndex(i++);
/* 2716 */       if (c1 == c2)
/*      */         continue; 
/* 2718 */       char c3 = Character.toUpperCase(c1);
/* 2719 */       char c4 = Character.toUpperCase(c2);
/* 2720 */       if (c3 == c4)
/*      */         continue; 
/* 2722 */       if (Character.toLowerCase(c3) != Character.toLowerCase(c4))
/* 2723 */         return false; 
/*      */     } 
/* 2725 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean hasBackReferences = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   transient int minlength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2757 */   transient Op operations = null;
/*      */   transient int numberOfClosures;
/* 2759 */   transient Context context = null;
/* 2760 */   transient RangeToken firstChar = null;
/*      */   
/* 2762 */   transient String fixedString = null;
/*      */   transient int fixedStringOptions;
/* 2764 */   transient BMPattern fixedStringTable = null; transient boolean fixedStringOnly = false; static final int IGNORE_CASE = 2; static final int SINGLE_LINE = 4; static final int MULTIPLE_LINES = 8; static final int EXTENDED_COMMENT = 16; static final int USE_UNICODE_CATEGORY = 32; static final int UNICODE_WORD_BOUNDARY = 64; static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128; static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256; static final int XMLSCHEMA_MODE = 512; static final int SPECIAL_COMMA = 1024; private static final int WT_IGNORE = 0;
/*      */   private static final int WT_LETTER = 1;
/*      */   private static final int WT_OTHER = 2;
/*      */   static final int LINE_FEED = 10;
/*      */   static final int CARRIAGE_RETURN = 13;
/*      */   static final int LINE_SEPARATOR = 8232;
/*      */   static final int PARAGRAPH_SEPARATOR = 8233;
/*      */   
/*      */   static final class Context { CharacterIterator ciTarget;
/*      */     String strTarget;
/*      */     char[] charTarget;
/*      */     int start;
/*      */     int limit;
/*      */     int length;
/*      */     Match match;
/*      */     boolean inuse = false;
/*      */     int[] offsets;
/*      */     
/*      */     private void resetCommon(int param1Int) {
/* 2783 */       this.length = this.limit - this.start;
/* 2784 */       this.inuse = true;
/* 2785 */       this.match = null;
/* 2786 */       if (this.offsets == null || this.offsets.length != param1Int)
/* 2787 */         this.offsets = new int[param1Int]; 
/* 2788 */       for (byte b = 0; b < param1Int; ) { this.offsets[b] = -1; b++; }
/*      */     
/*      */     } void reset(CharacterIterator param1CharacterIterator, int param1Int1, int param1Int2, int param1Int3) {
/* 2791 */       this.ciTarget = param1CharacterIterator;
/* 2792 */       this.start = param1Int1;
/* 2793 */       this.limit = param1Int2;
/* 2794 */       resetCommon(param1Int3);
/*      */     }
/*      */     void reset(String param1String, int param1Int1, int param1Int2, int param1Int3) {
/* 2797 */       this.strTarget = param1String;
/* 2798 */       this.start = param1Int1;
/* 2799 */       this.limit = param1Int2;
/* 2800 */       resetCommon(param1Int3);
/*      */     }
/*      */     void reset(char[] param1ArrayOfchar, int param1Int1, int param1Int2, int param1Int3) {
/* 2803 */       this.charTarget = param1ArrayOfchar;
/* 2804 */       this.start = param1Int1;
/* 2805 */       this.limit = param1Int2;
/* 2806 */       resetCommon(param1Int3);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void prepare() {
/* 2815 */     compile(this.tokentree);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2825 */     this.minlength = this.tokentree.getMinLength();
/*      */     
/* 2827 */     this.firstChar = null;
/* 2828 */     if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
/*      */       
/* 2830 */       RangeToken rangeToken = Token.createRange();
/* 2831 */       int i = this.tokentree.analyzeFirstCharacter(rangeToken, this.options);
/* 2832 */       if (i == 1) {
/* 2833 */         rangeToken.compactRanges();
/* 2834 */         this.firstChar = rangeToken;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2840 */     if (this.operations != null && (this.operations.type == 6 || this.operations.type == 1) && this.operations.next == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2845 */       this.fixedStringOnly = true;
/* 2846 */       if (this.operations.type == 6) {
/* 2847 */         this.fixedString = this.operations.getString();
/* 2848 */       } else if (this.operations.getData() >= 65536) {
/* 2849 */         this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
/*      */       } else {
/* 2851 */         char[] arrayOfChar = new char[1];
/* 2852 */         arrayOfChar[0] = (char)this.operations.getData();
/* 2853 */         this.fixedString = new String(arrayOfChar);
/*      */       } 
/* 2855 */       this.fixedStringOptions = this.options;
/* 2856 */       this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
/*      */     }
/* 2858 */     else if (!isSet(this.options, 256) && !isSet(this.options, 512)) {
/*      */       
/* 2860 */       Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
/* 2861 */       this.tokentree.findFixedString(fixedStringContainer, this.options);
/* 2862 */       this.fixedString = (fixedStringContainer.token == null) ? null : fixedStringContainer.token.getString();
/* 2863 */       this.fixedStringOptions = fixedStringContainer.options;
/* 2864 */       if (this.fixedString != null && this.fixedString.length() < 2) {
/* 2865 */         this.fixedString = null;
/*      */       }
/* 2867 */       if (this.fixedString != null) {
/* 2868 */         this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean isSet(int paramInt1, int paramInt2) {
/* 2954 */     return ((paramInt1 & paramInt2) == paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RegularExpression(String paramString) throws ParseException {
/* 2964 */     setPattern(paramString, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RegularExpression(String paramString1, String paramString2) throws ParseException {
/* 2975 */     setPattern(paramString1, paramString2);
/*      */   }
/*      */   
/*      */   RegularExpression(String paramString, Token paramToken, int paramInt1, boolean paramBoolean, int paramInt2) {
/* 2979 */     this.regex = paramString;
/* 2980 */     this.tokentree = paramToken;
/* 2981 */     this.nofparen = paramInt1;
/* 2982 */     this.options = paramInt2;
/* 2983 */     this.hasBackReferences = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPattern(String paramString) throws ParseException {
/* 2990 */     setPattern(paramString, this.options);
/*      */   }
/*      */   
/*      */   private void setPattern(String paramString, int paramInt) throws ParseException {
/* 2994 */     this.regex = paramString;
/* 2995 */     this.options = paramInt;
/* 2996 */     RegexParser regexParser = isSet(this.options, 512) ? new ParserForXMLSchema() : new RegexParser();
/*      */     
/* 2998 */     this.tokentree = regexParser.parse(this.regex, this.options);
/* 2999 */     this.nofparen = regexParser.parennumber;
/* 3000 */     this.hasBackReferences = regexParser.hasBackReferences;
/*      */     
/* 3002 */     this.operations = null;
/* 3003 */     this.context = null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPattern(String paramString1, String paramString2) throws ParseException {
/* 3009 */     setPattern(paramString1, REUtil.parseOptions(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPattern() {
/* 3016 */     return this.regex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 3023 */     return this.tokentree.toString(this.options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getOptions() {
/* 3035 */     return REUtil.createOptionString(this.options);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 3042 */     if (paramObject == null) return false; 
/* 3043 */     if (!(paramObject instanceof RegularExpression))
/* 3044 */       return false; 
/* 3045 */     RegularExpression regularExpression = (RegularExpression)paramObject;
/* 3046 */     return (this.regex.equals(regularExpression.regex) && this.options == regularExpression.options);
/*      */   }
/*      */   
/*      */   boolean equals(String paramString, int paramInt) {
/* 3050 */     return (this.regex.equals(paramString) && this.options == paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 3057 */     return (this.regex + "/" + getOptions()).hashCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfGroups() {
/* 3066 */     return this.nofparen;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int getWordType0(char paramChar, int paramInt) {
/* 3075 */     if (!isSet(paramInt, 64)) {
/* 3076 */       if (isSet(paramInt, 32)) {
/* 3077 */         return Token.getRange("IsWord", true).match(paramChar) ? 1 : 2;
/*      */       }
/* 3079 */       return isWordChar(paramChar) ? 1 : 2;
/*      */     } 
/*      */     
/* 3082 */     switch (Character.getType(paramChar)) {
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*      */       case 8:
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/* 3092 */         return 1;
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 16:
/* 3097 */         return 0;
/*      */       
/*      */       case 15:
/* 3100 */         switch (paramChar) {
/*      */           case '\t':
/*      */           case '\n':
/*      */           case '\013':
/*      */           case '\f':
/*      */           case '\r':
/* 3106 */             return 2;
/*      */         } 
/* 3108 */         return 0;
/*      */     } 
/*      */ 
/*      */     
/* 3112 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean isEOLChar(int paramInt) {
/* 3124 */     return (paramInt == 10 || paramInt == 13 || paramInt == 8232 || paramInt == 8233);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final boolean isWordChar(int paramInt) {
/* 3129 */     if (paramInt == 95) return true; 
/* 3130 */     if (paramInt < 48) return false; 
/* 3131 */     if (paramInt > 122) return false; 
/* 3132 */     if (paramInt <= 57) return true; 
/* 3133 */     if (paramInt < 65) return false; 
/* 3134 */     if (paramInt <= 90) return true; 
/* 3135 */     if (paramInt < 97) return false; 
/* 3136 */     return true;
/*      */   }
/*      */   
/*      */   private static final boolean matchIgnoreCase(int paramInt1, int paramInt2) {
/* 3140 */     if (paramInt1 == paramInt2) return true; 
/* 3141 */     if (paramInt1 > 65535 || paramInt2 > 65535) return false; 
/* 3142 */     char c1 = Character.toUpperCase((char)paramInt1);
/* 3143 */     char c2 = Character.toUpperCase((char)paramInt2);
/* 3144 */     if (c1 == c2) return true; 
/* 3145 */     return (Character.toLowerCase(c1) == Character.toLowerCase(c2));
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\RegularExpression.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */