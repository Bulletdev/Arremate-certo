/*     */ package org.apache.commons.text.diff;
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
/*     */ public class StringsComparator
/*     */ {
/*     */   private final String left;
/*     */   private final String right;
/*     */   private final int[] vDown;
/*     */   private final int[] vUp;
/*     */   
/*     */   public StringsComparator(String paramString1, String paramString2) {
/*  89 */     this.left = paramString1;
/*  90 */     this.right = paramString2;
/*     */     
/*  92 */     int i = paramString1.length() + paramString2.length() + 2;
/*  93 */     this.vDown = new int[i];
/*  94 */     this.vUp = new int[i];
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EditScript<Character> getScript() {
/* 112 */     EditScript<Character> editScript = new EditScript();
/* 113 */     buildScript(0, this.left.length(), 0, this.right.length(), editScript);
/* 114 */     return editScript;
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
/*     */   private void buildScript(int paramInt1, int paramInt2, int paramInt3, int paramInt4, EditScript<Character> paramEditScript) {
/* 128 */     Snake snake = getMiddleSnake(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     
/* 130 */     if (snake == null || (snake
/* 131 */       .getStart() == paramInt2 && snake.getDiag() == paramInt2 - paramInt4) || (snake
/* 132 */       .getEnd() == paramInt1 && snake.getDiag() == paramInt1 - paramInt3)) {
/*     */       
/* 134 */       int i = paramInt1;
/* 135 */       int j = paramInt3;
/* 136 */       while (i < paramInt2 || j < paramInt4) {
/* 137 */         if (i < paramInt2 && j < paramInt4 && this.left.charAt(i) == this.right.charAt(j)) {
/* 138 */           paramEditScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(i))));
/* 139 */           i++;
/* 140 */           j++; continue;
/*     */         } 
/* 142 */         if (paramInt2 - paramInt1 > paramInt4 - paramInt3) {
/* 143 */           paramEditScript.append(new DeleteCommand<>(Character.valueOf(this.left.charAt(i))));
/* 144 */           i++; continue;
/*     */         } 
/* 146 */         paramEditScript.append(new InsertCommand<>(Character.valueOf(this.right.charAt(j))));
/* 147 */         j++;
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 154 */       buildScript(paramInt1, snake.getStart(), paramInt3, snake
/* 155 */           .getStart() - snake.getDiag(), paramEditScript);
/*     */       
/* 157 */       for (int i = snake.getStart(); i < snake.getEnd(); i++) {
/* 158 */         paramEditScript.append(new KeepCommand<>(Character.valueOf(this.left.charAt(i))));
/*     */       }
/* 160 */       buildScript(snake.getEnd(), paramInt2, snake
/* 161 */           .getEnd() - snake.getDiag(), paramInt4, paramEditScript);
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
/*     */   private Snake getMiddleSnake(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 186 */     int i = paramInt2 - paramInt1;
/* 187 */     int j = paramInt4 - paramInt3;
/* 188 */     if (i == 0 || j == 0) {
/* 189 */       return null;
/*     */     }
/*     */     
/* 192 */     int k = i - j;
/* 193 */     int m = j + i;
/* 194 */     int n = ((m % 2 == 0) ? m : (m + 1)) / 2;
/* 195 */     this.vDown[1 + n] = paramInt1;
/* 196 */     this.vUp[1 + n] = paramInt2 + 1;
/*     */     
/* 198 */     for (byte b = 0; b <= n; b++) {
/*     */       int i1;
/* 200 */       for (i1 = -b; i1 <= b; i1 += 2) {
/*     */ 
/*     */         
/* 203 */         int i2 = i1 + n;
/* 204 */         if (i1 == -b || (i1 != b && this.vDown[i2 - 1] < this.vDown[i2 + 1])) {
/* 205 */           this.vDown[i2] = this.vDown[i2 + 1];
/*     */         } else {
/* 207 */           this.vDown[i2] = this.vDown[i2 - 1] + 1;
/*     */         } 
/*     */         
/* 210 */         int i3 = this.vDown[i2];
/* 211 */         int i4 = i3 - paramInt1 + paramInt3 - i1;
/*     */         
/* 213 */         while (i3 < paramInt2 && i4 < paramInt4 && this.left.charAt(i3) == this.right.charAt(i4)) {
/* 214 */           this.vDown[i2] = ++i3;
/* 215 */           i4++;
/*     */         } 
/*     */         
/* 218 */         if (k % 2 != 0 && k - b <= i1 && i1 <= k + b && 
/* 219 */           this.vUp[i2 - k] <= this.vDown[i2]) {
/* 220 */           return buildSnake(this.vUp[i2 - k], i1 + paramInt1 - paramInt3, paramInt2, paramInt4);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 226 */       for (i1 = k - b; i1 <= k + b; i1 += 2) {
/*     */         
/* 228 */         int i2 = i1 + n - k;
/* 229 */         if (i1 == k - b || (i1 != k + b && this.vUp[i2 + 1] <= this.vUp[i2 - 1])) {
/*     */           
/* 231 */           this.vUp[i2] = this.vUp[i2 + 1] - 1;
/*     */         } else {
/* 233 */           this.vUp[i2] = this.vUp[i2 - 1];
/*     */         } 
/*     */         
/* 236 */         int i3 = this.vUp[i2] - 1;
/* 237 */         int i4 = i3 - paramInt1 + paramInt3 - i1;
/* 238 */         while (i3 >= paramInt1 && i4 >= paramInt3 && this.left
/* 239 */           .charAt(i3) == this.right.charAt(i4)) {
/* 240 */           this.vUp[i2] = i3--;
/* 241 */           i4--;
/*     */         } 
/*     */         
/* 244 */         if (k % 2 == 0 && -b <= i1 && i1 <= b && 
/* 245 */           this.vUp[i2] <= this.vDown[i2 + k]) {
/* 246 */           return buildSnake(this.vUp[i2], i1 + paramInt1 - paramInt3, paramInt2, paramInt4);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 253 */     throw new RuntimeException("Internal Error");
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
/*     */   private Snake buildSnake(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 266 */     int i = paramInt1;
/* 267 */     while (i - paramInt2 < paramInt4 && i < paramInt3 && this.left
/*     */       
/* 269 */       .charAt(i) == this.right.charAt(i - paramInt2)) {
/* 270 */       i++;
/*     */     }
/* 272 */     return new Snake(paramInt1, i, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Snake
/*     */   {
/*     */     private final int start;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int end;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int diag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Snake(int param1Int1, int param1Int2, int param1Int3) {
/* 298 */       this.start = param1Int1;
/* 299 */       this.end = param1Int2;
/* 300 */       this.diag = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getStart() {
/* 309 */       return this.start;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getEnd() {
/* 318 */       return this.end;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDiag() {
/* 327 */       return this.diag;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\StringsComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */