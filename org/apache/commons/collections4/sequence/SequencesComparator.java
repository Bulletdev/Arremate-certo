/*     */ package org.apache.commons.collections4.sequence;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections4.Equator;
/*     */ import org.apache.commons.collections4.functors.DefaultEquator;
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
/*     */ public class SequencesComparator<T>
/*     */ {
/*     */   private final List<T> sequence1;
/*     */   private final List<T> sequence2;
/*     */   private final Equator<? super T> equator;
/*     */   private final int[] vDown;
/*     */   private final int[] vUp;
/*     */   
/*     */   public SequencesComparator(List<T> paramList1, List<T> paramList2) {
/*  89 */     this(paramList1, paramList2, (Equator<? super T>)DefaultEquator.defaultEquator());
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
/*     */   public SequencesComparator(List<T> paramList1, List<T> paramList2, Equator<? super T> paramEquator) {
/* 106 */     this.sequence1 = paramList1;
/* 107 */     this.sequence2 = paramList2;
/* 108 */     this.equator = paramEquator;
/*     */     
/* 110 */     int i = paramList1.size() + paramList2.size() + 2;
/* 111 */     this.vDown = new int[i];
/* 112 */     this.vUp = new int[i];
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
/*     */   public EditScript<T> getScript() {
/* 129 */     EditScript<T> editScript = new EditScript();
/* 130 */     buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
/* 131 */     return editScript;
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
/* 144 */     int i = paramInt1;
/* 145 */     while (i - paramInt2 < paramInt4 && i < paramInt3 && this.equator.equate(this.sequence1.get(i), this.sequence2.get(i - paramInt2)))
/*     */     {
/*     */       
/* 148 */       i++;
/*     */     }
/* 150 */     return new Snake(paramInt1, i, paramInt2);
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
/*     */   private Snake getMiddleSnake(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 172 */     int i = paramInt2 - paramInt1;
/* 173 */     int j = paramInt4 - paramInt3;
/* 174 */     if (i == 0 || j == 0) {
/* 175 */       return null;
/*     */     }
/*     */     
/* 178 */     int k = i - j;
/* 179 */     int m = j + i;
/* 180 */     int n = ((m % 2 == 0) ? m : (m + 1)) / 2;
/* 181 */     this.vDown[1 + n] = paramInt1;
/* 182 */     this.vUp[1 + n] = paramInt2 + 1;
/*     */     
/* 184 */     for (byte b = 0; b <= n; b++) {
/*     */       int i1;
/* 186 */       for (i1 = -b; i1 <= b; i1 += 2) {
/*     */ 
/*     */         
/* 189 */         int i2 = i1 + n;
/* 190 */         if (i1 == -b || (i1 != b && this.vDown[i2 - 1] < this.vDown[i2 + 1])) {
/* 191 */           this.vDown[i2] = this.vDown[i2 + 1];
/*     */         } else {
/* 193 */           this.vDown[i2] = this.vDown[i2 - 1] + 1;
/*     */         } 
/*     */         
/* 196 */         int i3 = this.vDown[i2];
/* 197 */         int i4 = i3 - paramInt1 + paramInt3 - i1;
/*     */         
/* 199 */         while (i3 < paramInt2 && i4 < paramInt4 && this.equator.equate(this.sequence1.get(i3), this.sequence2.get(i4))) {
/* 200 */           this.vDown[i2] = ++i3;
/* 201 */           i4++;
/*     */         } 
/*     */         
/* 204 */         if (k % 2 != 0 && k - b <= i1 && i1 <= k + b && 
/* 205 */           this.vUp[i2 - k] <= this.vDown[i2]) {
/* 206 */           return buildSnake(this.vUp[i2 - k], i1 + paramInt1 - paramInt3, paramInt2, paramInt4);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 212 */       for (i1 = k - b; i1 <= k + b; i1 += 2) {
/*     */         
/* 214 */         int i2 = i1 + n - k;
/* 215 */         if (i1 == k - b || (i1 != k + b && this.vUp[i2 + 1] <= this.vUp[i2 - 1])) {
/*     */           
/* 217 */           this.vUp[i2] = this.vUp[i2 + 1] - 1;
/*     */         } else {
/* 219 */           this.vUp[i2] = this.vUp[i2 - 1];
/*     */         } 
/*     */         
/* 222 */         int i3 = this.vUp[i2] - 1;
/* 223 */         int i4 = i3 - paramInt1 + paramInt3 - i1;
/* 224 */         while (i3 >= paramInt1 && i4 >= paramInt3 && this.equator.equate(this.sequence1.get(i3), this.sequence2.get(i4))) {
/*     */           
/* 226 */           this.vUp[i2] = i3--;
/* 227 */           i4--;
/*     */         } 
/*     */         
/* 230 */         if (k % 2 == 0 && -b <= i1 && i1 <= b && 
/* 231 */           this.vUp[i2] <= this.vDown[i2 + k]) {
/* 232 */           return buildSnake(this.vUp[i2], i1 + paramInt1 - paramInt3, paramInt2, paramInt4);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 239 */     throw new RuntimeException("Internal Error");
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
/*     */   private void buildScript(int paramInt1, int paramInt2, int paramInt3, int paramInt4, EditScript<T> paramEditScript) {
/* 255 */     Snake snake = getMiddleSnake(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     
/* 257 */     if (snake == null || (snake.getStart() == paramInt2 && snake.getDiag() == paramInt2 - paramInt4) || (snake.getEnd() == paramInt1 && snake.getDiag() == paramInt1 - paramInt3)) {
/*     */ 
/*     */ 
/*     */       
/* 261 */       int i = paramInt1;
/* 262 */       int j = paramInt3;
/* 263 */       while (i < paramInt2 || j < paramInt4) {
/* 264 */         if (i < paramInt2 && j < paramInt4 && this.equator.equate(this.sequence1.get(i), this.sequence2.get(j))) {
/* 265 */           paramEditScript.append(new KeepCommand<T>(this.sequence1.get(i)));
/* 266 */           i++;
/* 267 */           j++; continue;
/*     */         } 
/* 269 */         if (paramInt2 - paramInt1 > paramInt4 - paramInt3) {
/* 270 */           paramEditScript.append(new DeleteCommand<T>(this.sequence1.get(i)));
/* 271 */           i++; continue;
/*     */         } 
/* 273 */         paramEditScript.append(new InsertCommand<T>(this.sequence2.get(j)));
/* 274 */         j++;
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 281 */       buildScript(paramInt1, snake.getStart(), paramInt3, snake.getStart() - snake.getDiag(), paramEditScript);
/*     */ 
/*     */       
/* 284 */       for (int i = snake.getStart(); i < snake.getEnd(); i++) {
/* 285 */         paramEditScript.append(new KeepCommand<T>(this.sequence1.get(i)));
/*     */       }
/* 287 */       buildScript(snake.getEnd(), paramInt2, snake.getEnd() - snake.getDiag(), paramInt4, paramEditScript);
/*     */     } 
/*     */   }
/*     */ 
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
/*     */     public Snake(int param1Int1, int param1Int2, int param1Int3) {
/* 316 */       this.start = param1Int1;
/* 317 */       this.end = param1Int2;
/* 318 */       this.diag = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getStart() {
/* 327 */       return this.start;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getEnd() {
/* 336 */       return this.end;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getDiag() {
/* 345 */       return this.diag;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\sequence\SequencesComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */