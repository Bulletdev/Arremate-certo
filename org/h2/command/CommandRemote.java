/*     */ package org.h2.command;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.SessionRemote;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.expression.ParameterRemote;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.ResultRemote;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Transfer;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommandRemote
/*     */   implements CommandInterface
/*     */ {
/*     */   private final ArrayList<Transfer> transferList;
/*     */   private final ArrayList<ParameterInterface> parameters;
/*     */   private final Trace trace;
/*     */   private final String sql;
/*     */   private final int fetchSize;
/*     */   private SessionRemote session;
/*     */   private int id;
/*     */   private boolean isQuery;
/*     */   private boolean readonly;
/*     */   private final int created;
/*     */   
/*     */   public CommandRemote(SessionRemote paramSessionRemote, ArrayList<Transfer> paramArrayList, String paramString, int paramInt) {
/*  41 */     this.transferList = paramArrayList;
/*  42 */     this.trace = paramSessionRemote.getTrace();
/*  43 */     this.sql = paramString;
/*  44 */     this.parameters = New.arrayList();
/*  45 */     prepare(paramSessionRemote, true);
/*     */ 
/*     */     
/*  48 */     this.session = paramSessionRemote;
/*  49 */     this.fetchSize = paramInt;
/*  50 */     this.created = paramSessionRemote.getLastReconnect();
/*     */   }
/*     */   
/*     */   private void prepare(SessionRemote paramSessionRemote, boolean paramBoolean) {
/*  54 */     this.id = paramSessionRemote.getNextId();
/*  55 */     for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/*     */       try {
/*  57 */         Transfer transfer = this.transferList.get(b1);
/*  58 */         if (paramBoolean) {
/*  59 */           paramSessionRemote.traceOperation("SESSION_PREPARE_READ_PARAMS", this.id);
/*  60 */           transfer.writeInt(11).writeInt(this.id).writeString(this.sql);
/*     */         }
/*     */         else {
/*     */           
/*  64 */           paramSessionRemote.traceOperation("SESSION_PREPARE", this.id);
/*  65 */           transfer.writeInt(0).writeInt(this.id).writeString(this.sql);
/*     */         } 
/*     */         
/*  68 */         paramSessionRemote.done(transfer);
/*  69 */         this.isQuery = transfer.readBoolean();
/*  70 */         this.readonly = transfer.readBoolean();
/*  71 */         int i = transfer.readInt();
/*  72 */         if (paramBoolean) {
/*  73 */           this.parameters.clear();
/*  74 */           for (byte b = 0; b < i; b++) {
/*  75 */             ParameterRemote parameterRemote = new ParameterRemote(b);
/*  76 */             parameterRemote.readMetaData(transfer);
/*  77 */             this.parameters.add(parameterRemote);
/*     */           } 
/*     */         } 
/*  80 */       } catch (IOException iOException) {
/*  81 */         paramSessionRemote.removeServer(iOException, b1--, ++b2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/*  88 */     return this.isQuery;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<ParameterInterface> getParameters() {
/*  93 */     return this.parameters;
/*     */   }
/*     */   
/*     */   private void prepareIfRequired() {
/*  97 */     if (this.session.getLastReconnect() != this.created)
/*     */     {
/*  99 */       this.id = Integer.MIN_VALUE;
/*     */     }
/* 101 */     this.session.checkClosed();
/* 102 */     if (this.id <= this.session.getCurrentId() - SysProperties.SERVER_CACHED_OBJECTS)
/*     */     {
/* 104 */       prepare(this.session, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface getMetaData() {
/* 110 */     synchronized (this.session) {
/* 111 */       if (!this.isQuery) {
/* 112 */         return null;
/*     */       }
/* 114 */       int i = this.session.getNextId();
/* 115 */       ResultRemote resultRemote = null;
/* 116 */       for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 117 */         prepareIfRequired();
/* 118 */         Transfer transfer = this.transferList.get(b1);
/*     */         try {
/* 120 */           this.session.traceOperation("COMMAND_GET_META_DATA", this.id);
/* 121 */           transfer.writeInt(10).writeInt(this.id).writeInt(i);
/*     */           
/* 123 */           this.session.done(transfer);
/* 124 */           int j = transfer.readInt();
/* 125 */           resultRemote = new ResultRemote(this.session, transfer, i, j, 2147483647);
/*     */           
/*     */           break;
/* 128 */         } catch (IOException iOException) {
/* 129 */           this.session.removeServer(iOException, b1--, ++b2);
/*     */         } 
/*     */       } 
/* 132 */       this.session.autoCommitIfCluster();
/* 133 */       return (ResultInterface)resultRemote;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface executeQuery(int paramInt, boolean paramBoolean) {
/* 139 */     checkParameters();
/* 140 */     synchronized (this.session) {
/* 141 */       int i = this.session.getNextId();
/* 142 */       ResultRemote resultRemote = null;
/* 143 */       for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 144 */         prepareIfRequired();
/* 145 */         Transfer transfer = this.transferList.get(b1); try {
/*     */           int j;
/* 147 */           this.session.traceOperation("COMMAND_EXECUTE_QUERY", this.id);
/* 148 */           transfer.writeInt(2).writeInt(this.id).writeInt(i).writeInt(paramInt);
/*     */ 
/*     */           
/* 151 */           if (this.session.isClustered() || paramBoolean) {
/* 152 */             j = Integer.MAX_VALUE;
/*     */           } else {
/* 154 */             j = this.fetchSize;
/*     */           } 
/* 156 */           transfer.writeInt(j);
/* 157 */           sendParameters(transfer);
/* 158 */           this.session.done(transfer);
/* 159 */           int k = transfer.readInt();
/* 160 */           if (resultRemote != null) {
/* 161 */             resultRemote.close();
/* 162 */             resultRemote = null;
/*     */           } 
/* 164 */           resultRemote = new ResultRemote(this.session, transfer, i, k, j);
/* 165 */           if (this.readonly) {
/*     */             break;
/*     */           }
/* 168 */         } catch (IOException iOException) {
/* 169 */           this.session.removeServer(iOException, b1--, ++b2);
/*     */         } 
/*     */       } 
/* 172 */       this.session.autoCommitIfCluster();
/* 173 */       this.session.readSessionState();
/* 174 */       return (ResultInterface)resultRemote;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int executeUpdate() {
/* 180 */     checkParameters();
/* 181 */     synchronized (this.session) {
/* 182 */       int i = 0;
/* 183 */       boolean bool = false;
/* 184 */       for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 185 */         prepareIfRequired();
/* 186 */         Transfer transfer = this.transferList.get(b1);
/*     */         try {
/* 188 */           this.session.traceOperation("COMMAND_EXECUTE_UPDATE", this.id);
/* 189 */           transfer.writeInt(3).writeInt(this.id);
/* 190 */           sendParameters(transfer);
/* 191 */           this.session.done(transfer);
/* 192 */           i = transfer.readInt();
/* 193 */           bool = transfer.readBoolean();
/* 194 */         } catch (IOException iOException) {
/* 195 */           this.session.removeServer(iOException, b1--, ++b2);
/*     */         } 
/*     */       } 
/* 198 */       this.session.setAutoCommitFromServer(bool);
/* 199 */       this.session.autoCommitIfCluster();
/* 200 */       this.session.readSessionState();
/* 201 */       return i;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkParameters() {
/* 206 */     for (ParameterInterface parameterInterface : this.parameters) {
/* 207 */       parameterInterface.checkSet();
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendParameters(Transfer paramTransfer) throws IOException {
/* 212 */     int i = this.parameters.size();
/* 213 */     paramTransfer.writeInt(i);
/* 214 */     for (ParameterInterface parameterInterface : this.parameters) {
/* 215 */       paramTransfer.writeValue(parameterInterface.getParamValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 221 */     if (this.session == null || this.session.isClosed()) {
/*     */       return;
/*     */     }
/* 224 */     synchronized (this.session) {
/* 225 */       this.session.traceOperation("COMMAND_CLOSE", this.id);
/* 226 */       for (Transfer transfer : this.transferList) {
/*     */         try {
/* 228 */           transfer.writeInt(4).writeInt(this.id);
/* 229 */         } catch (IOException iOException) {
/* 230 */           this.trace.error(iOException, "close");
/*     */         } 
/*     */       } 
/*     */     } 
/* 234 */     this.session = null;
/*     */     try {
/* 236 */       for (ParameterInterface parameterInterface : this.parameters) {
/* 237 */         Value value = parameterInterface.getParamValue();
/* 238 */         if (value != null) {
/* 239 */           value.remove();
/*     */         }
/*     */       } 
/* 242 */     } catch (DbException dbException) {
/* 243 */       this.trace.error((Throwable)dbException, "close");
/*     */     } 
/* 245 */     this.parameters.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {
/* 253 */     this.session.cancelStatement(this.id);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 258 */     return this.sql + Trace.formatParams(getParameters());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCommandType() {
/* 263 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\CommandRemote.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */