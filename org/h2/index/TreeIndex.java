/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TreeIndex
/*     */   extends BaseIndex
/*     */ {
/*     */   private TreeNode root;
/*     */   private final RegularTable tableData;
/*     */   private long rowCount;
/*     */   private boolean closed;
/*     */   
/*     */   public TreeIndex(RegularTable paramRegularTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType) {
/*  34 */     initBaseIndex((Table)paramRegularTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  35 */     this.tableData = paramRegularTable;
/*  36 */     if (!this.database.isStarting()) {
/*  37 */       checkIndexColumnTypes(paramArrayOfIndexColumn);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/*  43 */     this.root = null;
/*  44 */     this.closed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  49 */     if (this.closed) {
/*  50 */       throw DbException.throwInternalError();
/*     */     }
/*  52 */     TreeNode treeNode1 = new TreeNode(paramRow);
/*  53 */     TreeNode treeNode2 = this.root, treeNode3 = treeNode2;
/*  54 */     boolean bool = true;
/*     */     while (true) {
/*  56 */       if (treeNode2 == null) {
/*  57 */         if (treeNode3 == null) {
/*  58 */           this.root = treeNode1;
/*  59 */           this.rowCount++;
/*     */           return;
/*     */         } 
/*  62 */         set(treeNode3, bool, treeNode1);
/*     */         break;
/*     */       } 
/*  65 */       Row row = treeNode2.row;
/*  66 */       int i = compareRows((SearchRow)paramRow, (SearchRow)row);
/*  67 */       if (i == 0) {
/*  68 */         if (this.indexType.isUnique() && 
/*  69 */           !containsNullAndAllowMultipleNull((SearchRow)paramRow)) {
/*  70 */           throw getDuplicateKeyException(paramRow.toString());
/*     */         }
/*     */         
/*  73 */         i = compareKeys((SearchRow)paramRow, (SearchRow)row);
/*     */       } 
/*  75 */       bool = (i < 0) ? true : false;
/*  76 */       treeNode3 = treeNode2;
/*  77 */       treeNode2 = child(treeNode3, bool);
/*     */     } 
/*  79 */     balance(treeNode3, bool);
/*  80 */     this.rowCount++;
/*     */   }
/*     */   private void balance(TreeNode paramTreeNode, boolean paramBoolean) {
/*     */     while (true) {
/*     */       TreeNode treeNode;
/*  85 */       byte b = paramBoolean ? 1 : -1;
/*  86 */       switch (paramTreeNode.balance * b) {
/*     */         case 1:
/*  88 */           paramTreeNode.balance = 0;
/*     */           return;
/*     */         case 0:
/*  91 */           paramTreeNode.balance = -b;
/*     */           break;
/*     */         case -1:
/*  94 */           treeNode = child(paramTreeNode, paramBoolean);
/*  95 */           if (treeNode.balance == -b) {
/*  96 */             replace(paramTreeNode, treeNode);
/*  97 */             set(paramTreeNode, paramBoolean, child(treeNode, !paramBoolean));
/*  98 */             set(treeNode, !paramBoolean, paramTreeNode);
/*  99 */             paramTreeNode.balance = 0;
/* 100 */             treeNode.balance = 0;
/*     */           } else {
/* 102 */             TreeNode treeNode1 = child(treeNode, !paramBoolean);
/* 103 */             replace(paramTreeNode, treeNode1);
/* 104 */             set(treeNode, !paramBoolean, child(treeNode1, paramBoolean));
/* 105 */             set(treeNode1, paramBoolean, treeNode);
/* 106 */             set(paramTreeNode, paramBoolean, child(treeNode1, !paramBoolean));
/* 107 */             set(treeNode1, !paramBoolean, paramTreeNode);
/* 108 */             int i = treeNode1.balance;
/* 109 */             paramTreeNode.balance = (i == -b) ? b : 0;
/* 110 */             treeNode.balance = (i == b) ? -b : 0;
/* 111 */             treeNode1.balance = 0;
/*     */           } 
/*     */           return;
/*     */         default:
/* 115 */           DbException.throwInternalError("b:" + (paramTreeNode.balance * b)); break;
/*     */       } 
/* 117 */       if (paramTreeNode == this.root) {
/*     */         return;
/*     */       }
/* 120 */       paramBoolean = paramTreeNode.isFromLeft();
/* 121 */       paramTreeNode = paramTreeNode.parent;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static TreeNode child(TreeNode paramTreeNode, boolean paramBoolean) {
/* 126 */     return paramBoolean ? paramTreeNode.left : paramTreeNode.right;
/*     */   }
/*     */   
/*     */   private void replace(TreeNode paramTreeNode1, TreeNode paramTreeNode2) {
/* 130 */     if (paramTreeNode1 == this.root) {
/* 131 */       this.root = paramTreeNode2;
/* 132 */       if (paramTreeNode2 != null) {
/* 133 */         paramTreeNode2.parent = null;
/*     */       }
/*     */     } else {
/* 136 */       set(paramTreeNode1.parent, paramTreeNode1.isFromLeft(), paramTreeNode2);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void set(TreeNode paramTreeNode1, boolean paramBoolean, TreeNode paramTreeNode2) {
/* 141 */     if (paramBoolean) {
/* 142 */       paramTreeNode1.left = paramTreeNode2;
/*     */     } else {
/* 144 */       paramTreeNode1.right = paramTreeNode2;
/*     */     } 
/* 146 */     if (paramTreeNode2 != null) {
/* 147 */       paramTreeNode2.parent = paramTreeNode1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 153 */     if (this.closed) {
/* 154 */       throw DbException.throwInternalError();
/*     */     }
/* 156 */     TreeNode treeNode1 = findFirstNode((SearchRow)paramRow, true);
/* 157 */     if (treeNode1 == null) {
/* 158 */       throw DbException.throwInternalError("not found!");
/*     */     }
/*     */     
/* 161 */     if (treeNode1.left == null) {
/* 162 */       treeNode2 = treeNode1.right;
/* 163 */     } else if (treeNode1.right == null) {
/* 164 */       treeNode2 = treeNode1.left;
/*     */     } else {
/* 166 */       TreeNode treeNode3 = treeNode1;
/* 167 */       treeNode1 = treeNode1.left;
/* 168 */       for (TreeNode treeNode4 = treeNode1; (treeNode4 = treeNode4.right) != null;) {
/* 169 */         treeNode1 = treeNode4;
/*     */       }
/*     */       
/* 172 */       treeNode2 = treeNode1.left;
/*     */       
/* 174 */       int i = treeNode1.balance;
/* 175 */       treeNode1.balance = treeNode3.balance;
/* 176 */       treeNode3.balance = i;
/*     */ 
/*     */       
/* 179 */       TreeNode treeNode5 = treeNode1.parent;
/* 180 */       TreeNode treeNode6 = treeNode3.parent;
/* 181 */       if (treeNode3 == this.root) {
/* 182 */         this.root = treeNode1;
/*     */       }
/* 184 */       treeNode1.parent = treeNode6;
/* 185 */       if (treeNode6 != null) {
/* 186 */         if (treeNode6.right == treeNode3) {
/* 187 */           treeNode6.right = treeNode1;
/*     */         } else {
/* 189 */           treeNode6.left = treeNode1;
/*     */         } 
/*     */       }
/*     */       
/* 193 */       if (treeNode5 == treeNode3) {
/* 194 */         treeNode3.parent = treeNode1;
/* 195 */         if (treeNode3.left == treeNode1) {
/* 196 */           treeNode1.left = treeNode3;
/* 197 */           treeNode1.right = treeNode3.right;
/*     */         } else {
/* 199 */           treeNode1.right = treeNode3;
/* 200 */           treeNode1.left = treeNode3.left;
/*     */         } 
/*     */       } else {
/* 203 */         treeNode3.parent = treeNode5;
/* 204 */         treeNode5.right = treeNode3;
/* 205 */         treeNode1.right = treeNode3.right;
/* 206 */         treeNode1.left = treeNode3.left;
/*     */       } 
/*     */       
/* 209 */       if (SysProperties.CHECK && treeNode1.right == null) {
/* 210 */         DbException.throwInternalError("tree corrupted");
/*     */       }
/* 212 */       treeNode1.right.parent = treeNode1;
/* 213 */       treeNode1.left.parent = treeNode1;
/*     */       
/* 215 */       treeNode3.left = treeNode2;
/* 216 */       if (treeNode2 != null) {
/* 217 */         treeNode2.parent = treeNode3;
/*     */       }
/* 219 */       treeNode3.right = null;
/* 220 */       treeNode1 = treeNode3;
/*     */     } 
/* 222 */     this.rowCount--;
/*     */     
/* 224 */     boolean bool = treeNode1.isFromLeft();
/* 225 */     replace(treeNode1, treeNode2);
/* 226 */     TreeNode treeNode2 = treeNode1.parent;
/* 227 */     while (treeNode2 != null) {
/* 228 */       TreeNode treeNode3; int i; TreeNode treeNode4; treeNode1 = treeNode2;
/* 229 */       byte b = bool ? 1 : -1;
/* 230 */       switch (treeNode1.balance * b) {
/*     */         case -1:
/* 232 */           treeNode1.balance = 0;
/*     */           break;
/*     */         case 0:
/* 235 */           treeNode1.balance = b;
/*     */           return;
/*     */         case 1:
/* 238 */           treeNode3 = child(treeNode1, !bool);
/* 239 */           i = treeNode3.balance;
/* 240 */           if (i * b >= 0) {
/* 241 */             replace(treeNode1, treeNode3);
/* 242 */             set(treeNode1, !bool, child(treeNode3, bool));
/* 243 */             set(treeNode3, bool, treeNode1);
/* 244 */             if (i == 0) {
/* 245 */               treeNode1.balance = b;
/* 246 */               treeNode3.balance = -b;
/*     */               return;
/*     */             } 
/* 249 */             treeNode1.balance = 0;
/* 250 */             treeNode3.balance = 0;
/* 251 */             treeNode1 = treeNode3; break;
/*     */           } 
/* 253 */           treeNode4 = child(treeNode3, bool);
/* 254 */           replace(treeNode1, treeNode4);
/* 255 */           i = treeNode4.balance;
/* 256 */           set(treeNode3, bool, child(treeNode4, !bool));
/* 257 */           set(treeNode4, !bool, treeNode3);
/* 258 */           set(treeNode1, !bool, child(treeNode4, bool));
/* 259 */           set(treeNode4, bool, treeNode1);
/* 260 */           treeNode1.balance = (i == b) ? -b : 0;
/* 261 */           treeNode3.balance = (i == -b) ? b : 0;
/* 262 */           treeNode4.balance = 0;
/* 263 */           treeNode1 = treeNode4;
/*     */           break;
/*     */         
/*     */         default:
/* 267 */           DbException.throwInternalError("b: " + (treeNode1.balance * b)); break;
/*     */       } 
/* 269 */       bool = treeNode1.isFromLeft();
/* 270 */       treeNode2 = treeNode1.parent;
/*     */     } 
/*     */   }
/*     */   
/*     */   private TreeNode findFirstNode(SearchRow paramSearchRow, boolean paramBoolean) {
/* 275 */     TreeNode treeNode1 = this.root, treeNode2 = treeNode1;
/* 276 */     while (treeNode1 != null) {
/* 277 */       treeNode2 = treeNode1;
/* 278 */       int i = compareRows((SearchRow)treeNode1.row, paramSearchRow);
/* 279 */       if (i == 0 && paramBoolean) {
/* 280 */         i = compareKeys((SearchRow)treeNode1.row, paramSearchRow);
/*     */       }
/* 282 */       if (i == 0) {
/* 283 */         if (paramBoolean) {
/* 284 */           return treeNode1;
/*     */         }
/* 286 */         treeNode1 = treeNode1.left; continue;
/* 287 */       }  if (i > 0) {
/* 288 */         treeNode1 = treeNode1.left; continue;
/*     */       } 
/* 290 */       treeNode1 = treeNode1.right;
/*     */     } 
/*     */     
/* 293 */     return treeNode2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(TableFilter paramTableFilter, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 298 */     return find(paramSearchRow1, paramSearchRow2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 303 */     return find(paramSearchRow1, paramSearchRow2);
/*     */   }
/*     */   
/*     */   private Cursor find(SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 307 */     if (paramSearchRow1 == null) {
/* 308 */       TreeNode treeNode1 = this.root;
/* 309 */       while (treeNode1 != null) {
/* 310 */         TreeNode treeNode2 = treeNode1.left;
/* 311 */         if (treeNode2 == null) {
/*     */           break;
/*     */         }
/* 314 */         treeNode1 = treeNode2;
/*     */       } 
/* 316 */       return new TreeCursor(this, treeNode1, null, paramSearchRow2);
/*     */     } 
/* 318 */     TreeNode treeNode = findFirstNode(paramSearchRow1, false);
/* 319 */     return new TreeCursor(this, treeNode, paramSearchRow1, paramSearchRow2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 325 */     return getCostRangeIndex(paramArrayOfint, this.tableData.getRowCountApproximation(), paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 331 */     truncate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 336 */     this.root = null;
/* 337 */     this.rowCount = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 347 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 352 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 357 */     if (this.closed) {
/* 358 */       throw DbException.throwInternalError();
/*     */     }
/* 360 */     if (paramBoolean) {
/*     */       
/* 362 */       Cursor cursor = find(paramSession, (SearchRow)null, (SearchRow)null);
/* 363 */       while (cursor.next()) {
/* 364 */         SearchRow searchRow = cursor.getSearchRow();
/* 365 */         Value value = searchRow.getValue(this.columnIds[0]);
/* 366 */         if (value != ValueNull.INSTANCE) {
/* 367 */           return cursor;
/*     */         }
/*     */       } 
/* 370 */       return cursor;
/*     */     } 
/* 372 */     TreeNode treeNode = this.root;
/* 373 */     while (treeNode != null) {
/* 374 */       TreeNode treeNode1 = treeNode.right;
/* 375 */       if (treeNode1 == null) {
/*     */         break;
/*     */       }
/* 378 */       treeNode = treeNode1;
/*     */     } 
/* 380 */     TreeCursor treeCursor = new TreeCursor(this, treeNode, null, null);
/* 381 */     if (treeNode == null) {
/* 382 */       return treeCursor;
/*     */     }
/*     */     
/*     */     do {
/* 386 */       SearchRow searchRow = treeCursor.getSearchRow();
/* 387 */       if (searchRow == null) {
/*     */         break;
/*     */       }
/* 390 */       Value value = searchRow.getValue(this.columnIds[0]);
/* 391 */       if (value != ValueNull.INSTANCE) {
/* 392 */         return treeCursor;
/*     */       }
/* 394 */     } while (treeCursor.previous());
/* 395 */     return treeCursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 400 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 405 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 410 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\TreeIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */