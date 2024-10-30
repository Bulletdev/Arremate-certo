/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.win32.W32APIOptions;
/*      */ import java.io.Closeable;
/*      */ import java.io.IOException;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationHandler;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Proxy;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class DdemlUtil
/*      */ {
/*      */   public static class StandaloneDdeClient
/*      */     implements IDdeClient, Closeable
/*      */   {
/*   66 */     private final User32Util.MessageLoopThread messageLoop = new User32Util.MessageLoopThread();
/*      */     private final DdemlUtil.IDdeClient ddeClient;
/*      */     private final DdemlUtil.IDdeClient clientDelegate;
/*      */     
/*      */     public StandaloneDdeClient() {
/*   71 */       this.ddeClient = new DdemlUtil.DdeClient();
/*   72 */       (new Class[1])[0] = DdemlUtil.IDdeClient.class; this.messageLoop.getClass(); DdemlUtil.IDdeClient iDdeClient = (DdemlUtil.IDdeClient)Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[1], new User32Util.MessageLoopThread.Handler(this.messageLoop, this.ddeClient));
/*      */ 
/*      */       
/*   75 */       this.clientDelegate = (DdemlUtil.IDdeClient)Proxy.newProxyInstance(StandaloneDdeClient.class.getClassLoader(), new Class[] { DdemlUtil.IDdeClient.class }, new DdemlUtil.MessageLoopWrapper(this.messageLoop, iDdeClient));
/*      */ 
/*      */       
/*   78 */       this.messageLoop.setDaemon(true);
/*   79 */       this.messageLoop.start();
/*      */     }
/*      */     
/*      */     public Integer getInstanceIdentitifier() {
/*   83 */       return this.ddeClient.getInstanceIdentitifier();
/*      */     }
/*      */     
/*      */     public void initialize(int param1Int) throws DdemlUtil.DdemlException {
/*   87 */       this.clientDelegate.initialize(param1Int);
/*      */     }
/*      */     
/*      */     public Ddeml.HSZ createStringHandle(String param1String) throws DdemlUtil.DdemlException {
/*   91 */       return this.clientDelegate.createStringHandle(param1String);
/*      */     }
/*      */     
/*      */     public void nameService(Ddeml.HSZ param1HSZ, int param1Int) throws DdemlUtil.DdemlException {
/*   95 */       this.clientDelegate.nameService(param1HSZ, param1Int);
/*      */     }
/*      */     
/*      */     public int getLastError() {
/*   99 */       return this.clientDelegate.getLastError();
/*      */     }
/*      */     
/*      */     public DdemlUtil.IDdeConnection connect(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  103 */       return this.clientDelegate.connect(param1HSZ1, param1HSZ2, param1CONVCONTEXT);
/*      */     }
/*      */     
/*      */     public String queryString(Ddeml.HSZ param1HSZ) throws DdemlUtil.DdemlException {
/*  107 */       return this.clientDelegate.queryString(param1HSZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HDDEDATA createDataHandle(Pointer param1Pointer, int param1Int1, int param1Int2, Ddeml.HSZ param1HSZ, int param1Int3, int param1Int4) {
/*  112 */       return this.clientDelegate.createDataHandle(param1Pointer, param1Int1, param1Int2, param1HSZ, param1Int3, param1Int4);
/*      */     }
/*      */ 
/*      */     
/*      */     public void freeDataHandle(Ddeml.HDDEDATA param1HDDEDATA) {
/*  117 */       this.clientDelegate.freeDataHandle(param1HDDEDATA);
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HDDEDATA addData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2) {
/*  122 */       return this.clientDelegate.addData(param1HDDEDATA, param1Pointer, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int getData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2) {
/*  127 */       return this.clientDelegate.getData(param1HDDEDATA, param1Pointer, param1Int1, param1Int2);
/*      */     }
/*      */ 
/*      */     
/*      */     public Pointer accessData(Ddeml.HDDEDATA param1HDDEDATA, WinDef.DWORDByReference param1DWORDByReference) {
/*  132 */       return this.clientDelegate.accessData(param1HDDEDATA, param1DWORDByReference);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unaccessData(Ddeml.HDDEDATA param1HDDEDATA) {
/*  137 */       this.clientDelegate.unaccessData(param1HDDEDATA);
/*      */     }
/*      */ 
/*      */     
/*      */     public void postAdvise(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/*  142 */       this.clientDelegate.postAdvise(param1HSZ1, param1HSZ2);
/*      */     }
/*      */     
/*      */     public void close() throws IOException {
/*  146 */       this.clientDelegate.uninitialize();
/*  147 */       this.messageLoop.exit();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean freeStringHandle(Ddeml.HSZ param1HSZ) {
/*  152 */       return this.clientDelegate.freeStringHandle(param1HSZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean keepStringHandle(Ddeml.HSZ param1HSZ) {
/*  157 */       return this.clientDelegate.keepStringHandle(param1HSZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public void abandonTransactions() {
/*  162 */       this.clientDelegate.abandonTransactions();
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnectionList connectList(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  167 */       return this.clientDelegate.connectList(param1HSZ1, param1HSZ2, param1IDdeConnectionList, param1CONVCONTEXT);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean enableCallback(int param1Int) {
/*  172 */       return this.clientDelegate.enableCallback(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnection wrap(Ddeml.HCONV param1HCONV) {
/*  177 */       return this.clientDelegate.wrap(param1HCONV);
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnection connect(String param1String1, String param1String2, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  182 */       return this.clientDelegate.connect(param1String1, param1String2, param1CONVCONTEXT);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean uninitialize() {
/*  187 */       return this.clientDelegate.uninitialize();
/*      */     }
/*      */ 
/*      */     
/*      */     public void postAdvise(String param1String1, String param1String2) {
/*  192 */       this.clientDelegate.postAdvise(param1String1, param1String2);
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnectionList connectList(String param1String1, String param1String2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  197 */       return this.clientDelegate.connectList(param1String1, param1String2, param1IDdeConnectionList, param1CONVCONTEXT);
/*      */     }
/*      */ 
/*      */     
/*      */     public void nameService(String param1String, int param1Int) throws DdemlUtil.DdemlException {
/*  202 */       this.clientDelegate.nameService(param1String, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/*  207 */       this.clientDelegate.registerAdvstartHandler(param1AdvstartHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/*  212 */       this.clientDelegate.unregisterAdvstartHandler(param1AdvstartHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/*  217 */       this.clientDelegate.registerAdvstopHandler(param1AdvstopHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/*  222 */       this.clientDelegate.unregisterAdvstopHandler(param1AdvstopHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/*  227 */       this.clientDelegate.registerConnectHandler(param1ConnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/*  232 */       this.clientDelegate.unregisterConnectHandler(param1ConnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/*  237 */       this.clientDelegate.registerAdvReqHandler(param1AdvreqHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/*  242 */       this.clientDelegate.unregisterAdvReqHandler(param1AdvreqHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/*  247 */       this.clientDelegate.registerRequestHandler(param1RequestHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/*  252 */       this.clientDelegate.unregisterRequestHandler(param1RequestHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/*  257 */       this.clientDelegate.registerWildconnectHandler(param1WildconnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/*  262 */       this.clientDelegate.unregisterWildconnectHandler(param1WildconnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/*  267 */       this.clientDelegate.registerAdvdataHandler(param1AdvdataHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/*  272 */       this.clientDelegate.unregisterAdvdataHandler(param1AdvdataHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/*  277 */       this.clientDelegate.registerExecuteHandler(param1ExecuteHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/*  282 */       this.clientDelegate.unregisterExecuteHandler(param1ExecuteHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/*  287 */       this.clientDelegate.registerPokeHandler(param1PokeHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/*  292 */       this.clientDelegate.unregisterPokeHandler(param1PokeHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/*  297 */       this.clientDelegate.registerConnectConfirmHandler(param1ConnectConfirmHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/*  302 */       this.clientDelegate.unregisterConnectConfirmHandler(param1ConnectConfirmHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/*  307 */       this.clientDelegate.registerDisconnectHandler(param1DisconnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/*  312 */       this.clientDelegate.unregisterDisconnectHandler(param1DisconnectHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/*  317 */       this.clientDelegate.registerErrorHandler(param1ErrorHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/*  322 */       this.clientDelegate.unregisterErrorHandler(param1ErrorHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/*  327 */       this.clientDelegate.registerRegisterHandler(param1RegisterHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/*  332 */       this.clientDelegate.unregisterRegisterHandler(param1RegisterHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/*  337 */       this.clientDelegate.registerXactCompleteHandler(param1XactCompleteHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/*  342 */       this.clientDelegate.unregisterXactCompleteHandler(param1XactCompleteHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/*  347 */       this.clientDelegate.registerUnregisterHandler(param1UnregisterHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/*  352 */       this.clientDelegate.unregisterUnregisterHandler(param1UnregisterHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void registerMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/*  357 */       this.clientDelegate.registerMonitorHandler(param1MonitorHandler);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/*  362 */       this.clientDelegate.unregisterMonitorHandler(param1MonitorHandler);
/*      */     }
/*      */   }
/*      */   
/*      */   private static class MessageLoopWrapper implements InvocationHandler {
/*      */     private final Object delegate;
/*      */     private final User32Util.MessageLoopThread loopThread;
/*      */     
/*      */     public MessageLoopWrapper(User32Util.MessageLoopThread param1MessageLoopThread, Object param1Object) {
/*  371 */       this.loopThread = param1MessageLoopThread;
/*  372 */       this.delegate = param1Object;
/*      */     }
/*      */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/*      */       try {
/*      */         Class<DdemlUtil.IDdeClient> clazz;
/*  377 */         Object object = param1Method.invoke(this.delegate, param1ArrayOfObject);
/*  378 */         Class<DdemlUtil.IDdeConnection> clazz1 = null;
/*  379 */         if (object instanceof DdemlUtil.IDdeConnection) {
/*  380 */           clazz1 = DdemlUtil.IDdeConnection.class;
/*  381 */         } else if (object instanceof DdemlUtil.IDdeConnectionList) {
/*  382 */           Class<DdemlUtil.IDdeConnectionList> clazz2 = DdemlUtil.IDdeConnectionList.class;
/*  383 */         } else if (object instanceof DdemlUtil.IDdeClient) {
/*  384 */           clazz = DdemlUtil.IDdeClient.class;
/*      */         } 
/*  386 */         if (clazz != null && param1Method.getReturnType().isAssignableFrom(clazz)) {
/*  387 */           object = wrap(object, clazz);
/*      */         }
/*  389 */         return object;
/*  390 */       } catch (InvocationTargetException invocationTargetException) {
/*  391 */         Throwable throwable = invocationTargetException.getCause();
/*  392 */         if (throwable instanceof Exception) {
/*  393 */           throw (Exception)throwable;
/*      */         }
/*  395 */         throw invocationTargetException;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private <V> V wrap(V param1V, Class param1Class) {
/*  401 */       (new Class[1])[0] = param1Class; this.loopThread.getClass(); Object object = Proxy.newProxyInstance(DdemlUtil.StandaloneDdeClient.class.getClassLoader(), new Class[1], new User32Util.MessageLoopThread.Handler(this.loopThread, param1V));
/*      */ 
/*      */       
/*  404 */       return (V)Proxy.newProxyInstance(DdemlUtil.StandaloneDdeClient.class.getClassLoader(), new Class[] { param1Class }, new MessageLoopWrapper(this.loopThread, object));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class DdeConnection
/*      */     implements IDdeConnection
/*      */   {
/*      */     private Ddeml.HCONV conv;
/*      */     private final DdemlUtil.IDdeClient client;
/*      */     
/*      */     public DdeConnection(DdemlUtil.IDdeClient param1IDdeClient, Ddeml.HCONV param1HCONV) {
/*  416 */       this.conv = param1HCONV;
/*  417 */       this.client = param1IDdeClient;
/*      */     }
/*      */     
/*      */     public Ddeml.HCONV getConv() {
/*  421 */       return this.conv;
/*      */     }
/*      */ 
/*      */     
/*      */     public void abandonTransaction(int param1Int) {
/*  426 */       boolean bool = Ddeml.INSTANCE.DdeAbandonTransaction(this.client.getInstanceIdentitifier().intValue(), this.conv, param1Int);
/*  427 */       if (!bool) {
/*  428 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void abandonTransactions() {
/*  433 */       boolean bool = Ddeml.INSTANCE.DdeAbandonTransaction(this.client.getInstanceIdentitifier().intValue(), this.conv, 0);
/*  434 */       if (!bool) {
/*  435 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HDDEDATA clientTransaction(Pointer param1Pointer, int param1Int1, Ddeml.HSZ param1HSZ, int param1Int2, int param1Int3, int param1Int4, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  441 */       if (param1Int4 == -1 && param1DWORDByReference == null) {
/*  442 */         param1DWORDByReference = new WinDef.DWORDByReference();
/*      */       }
/*  444 */       Ddeml.HDDEDATA hDDEDATA = Ddeml.INSTANCE.DdeClientTransaction(param1Pointer, param1Int1, this.conv, param1HSZ, param1Int2, param1Int3, param1Int4, param1DWORDByReference);
/*  445 */       if (hDDEDATA == null) {
/*  446 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*  448 */       if (param1DWORD_PTR != null) {
/*  449 */         if (param1Int4 != -1) {
/*  450 */           setUserHandle(-1, param1DWORD_PTR);
/*      */         } else {
/*  452 */           setUserHandle(param1DWORDByReference.getValue().intValue(), param1DWORD_PTR);
/*      */         } 
/*      */       }
/*  455 */       return hDDEDATA;
/*      */     }
/*      */     
/*      */     public Ddeml.HDDEDATA clientTransaction(Pointer param1Pointer, int param1Int1, String param1String, int param1Int2, int param1Int3, int param1Int4, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  459 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  461 */         hSZ = this.client.createStringHandle(param1String);
/*  462 */         return clientTransaction(param1Pointer, param1Int1, hSZ, param1Int2, param1Int3, param1Int4, param1DWORDByReference, param1DWORD_PTR);
/*      */       } finally {
/*  464 */         this.client.freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void poke(Pointer param1Pointer, int param1Int1, Ddeml.HSZ param1HSZ, int param1Int2, int param1Int3, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  470 */       clientTransaction(param1Pointer, param1Int1, param1HSZ, param1Int2, 16528, param1Int3, param1DWORDByReference, param1DWORD_PTR);
/*      */     }
/*      */     
/*      */     public void poke(Pointer param1Pointer, int param1Int1, String param1String, int param1Int2, int param1Int3, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  474 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  476 */         hSZ = this.client.createStringHandle(param1String);
/*  477 */         poke(param1Pointer, param1Int1, hSZ, param1Int2, param1Int3, param1DWORDByReference, param1DWORD_PTR);
/*      */       } finally {
/*  479 */         this.client.freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HDDEDATA request(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  485 */       return clientTransaction(Pointer.NULL, 0, param1HSZ, param1Int1, 8368, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */     }
/*      */     
/*      */     public Ddeml.HDDEDATA request(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  489 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  491 */         hSZ = this.client.createStringHandle(param1String);
/*  492 */         return request(hSZ, param1Int1, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */       } finally {
/*  494 */         this.client.freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void execute(String param1String, int param1Int, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  500 */       Memory memory = new Memory((param1String.length() * 2 + 2));
/*  501 */       memory.setWideString(0L, param1String);
/*  502 */       clientTransaction((Pointer)memory, (int)memory.size(), (Ddeml.HSZ)null, 0, 16464, param1Int, param1DWORDByReference, param1DWORD_PTR);
/*      */     }
/*      */ 
/*      */     
/*      */     public void advstart(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  507 */       clientTransaction(Pointer.NULL, 0, param1HSZ, param1Int1, 4144, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */     }
/*      */     
/*      */     public void advstart(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  511 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  513 */         hSZ = this.client.createStringHandle(param1String);
/*  514 */         advstart(hSZ, param1Int1, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */       } finally {
/*  516 */         this.client.freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void advstop(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  522 */       clientTransaction(Pointer.NULL, 0, param1HSZ, param1Int1, 32832, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */     }
/*      */     
/*      */     public void advstop(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR) {
/*  526 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  528 */         hSZ = this.client.createStringHandle(param1String);
/*  529 */         advstop(hSZ, param1Int1, param1Int2, param1DWORDByReference, param1DWORD_PTR);
/*      */       } finally {
/*  531 */         this.client.freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */     
/*      */     public void impersonateClient() {
/*  536 */       boolean bool = Ddeml.INSTANCE.DdeImpersonateClient(this.conv);
/*  537 */       if (!bool) {
/*  538 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void close() {
/*  543 */       boolean bool = Ddeml.INSTANCE.DdeDisconnect(this.conv);
/*  544 */       if (!bool) {
/*  545 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void reconnect() {
/*  550 */       Ddeml.HCONV hCONV = Ddeml.INSTANCE.DdeReconnect(this.conv);
/*  551 */       if (hCONV != null) {
/*  552 */         this.conv = hCONV;
/*      */       } else {
/*  554 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       } 
/*      */     }
/*      */     
/*      */     public boolean enableCallback(int param1Int) {
/*  559 */       boolean bool = Ddeml.INSTANCE.DdeEnableCallback(this.client.getInstanceIdentitifier().intValue(), this.conv, param1Int);
/*  560 */       if (!bool && param1Int == 2) {
/*  561 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*  563 */       return bool;
/*      */     }
/*      */     
/*      */     public void setUserHandle(int param1Int, BaseTSD.DWORD_PTR param1DWORD_PTR) throws DdemlUtil.DdemlException {
/*  567 */       boolean bool = Ddeml.INSTANCE.DdeSetUserHandle(this.conv, param1Int, param1DWORD_PTR);
/*  568 */       if (!bool) {
/*  569 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public Ddeml.CONVINFO queryConvInfo(int param1Int) throws DdemlUtil.DdemlException {
/*  574 */       Ddeml.CONVINFO cONVINFO = new Ddeml.CONVINFO();
/*  575 */       cONVINFO.cb = cONVINFO.size();
/*  576 */       cONVINFO.ConvCtxt.cb = cONVINFO.ConvCtxt.size();
/*  577 */       cONVINFO.write();
/*  578 */       int i = Ddeml.INSTANCE.DdeQueryConvInfo(this.conv, param1Int, cONVINFO);
/*  579 */       if (i == 0) {
/*  580 */         throw DdemlUtil.DdemlException.create(this.client.getLastError());
/*      */       }
/*  582 */       return cONVINFO;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DdeConnectionList
/*      */     implements IDdeConnectionList {
/*      */     private final DdemlUtil.IDdeClient client;
/*      */     private final Ddeml.HCONVLIST convList;
/*      */     
/*      */     public DdeConnectionList(DdemlUtil.IDdeClient param1IDdeClient, Ddeml.HCONVLIST param1HCONVLIST) {
/*  592 */       this.convList = param1HCONVLIST;
/*  593 */       this.client = param1IDdeClient;
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HCONVLIST getHandle() {
/*  598 */       return this.convList;
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnection queryNextServer(DdemlUtil.IDdeConnection param1IDdeConnection) {
/*  603 */       Ddeml.HCONV hCONV = Ddeml.INSTANCE.DdeQueryNextServer(this.convList, (param1IDdeConnection != null) ? param1IDdeConnection
/*      */           
/*  605 */           .getConv() : null);
/*  606 */       if (hCONV != null) {
/*  607 */         return new DdemlUtil.DdeConnection(this.client, hCONV);
/*      */       }
/*  609 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  615 */       boolean bool = Ddeml.INSTANCE.DdeDisconnectList(this.convList);
/*  616 */       if (!bool)
/*  617 */         throw DdemlUtil.DdemlException.create(this.client.getLastError()); 
/*      */     }
/*      */   }
/*      */   
/*      */   public static class DdeClient
/*      */     implements IDdeClient {
/*      */     private Integer idInst;
/*  624 */     private final DdemlUtil.DdeAdapter ddeAdapter = new DdemlUtil.DdeAdapter();
/*      */     
/*      */     public Integer getInstanceIdentitifier() {
/*  627 */       return this.idInst;
/*      */     }
/*      */     
/*      */     public void initialize(int param1Int) throws DdemlUtil.DdemlException {
/*  631 */       WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/*  632 */       Integer integer = Integer.valueOf(Ddeml.INSTANCE.DdeInitialize(dWORDByReference, this.ddeAdapter, param1Int, 0));
/*  633 */       if (integer.intValue() != 0) {
/*  634 */         throw DdemlUtil.DdemlException.create(integer.intValue());
/*      */       }
/*  636 */       this.idInst = Integer.valueOf(dWORDByReference.getValue().intValue());
/*  637 */       if (this.ddeAdapter instanceof DdemlUtil.DdeAdapter)
/*  638 */         this.ddeAdapter.setInstanceIdentifier(this.idInst.intValue()); 
/*      */     }
/*      */     
/*      */     public Ddeml.HSZ createStringHandle(String param1String) throws DdemlUtil.DdemlException {
/*      */       char c;
/*  643 */       if (param1String == null) {
/*  644 */         return null;
/*      */       }
/*      */       
/*  647 */       if (W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS) {
/*  648 */         c = 'Ұ';
/*      */       } else {
/*  650 */         c = 'Ϭ';
/*      */       } 
/*  652 */       Ddeml.HSZ hSZ = Ddeml.INSTANCE.DdeCreateStringHandle(this.idInst.intValue(), param1String, c);
/*  653 */       if (hSZ == null) {
/*  654 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  656 */       return hSZ;
/*      */     }
/*      */     
/*      */     public void nameService(Ddeml.HSZ param1HSZ, int param1Int) throws DdemlUtil.DdemlException {
/*  660 */       Ddeml.HDDEDATA hDDEDATA = Ddeml.INSTANCE.DdeNameService(this.idInst.intValue(), param1HSZ, new Ddeml.HSZ(), param1Int);
/*  661 */       if (hDDEDATA == null) {
/*  662 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void nameService(String param1String, int param1Int) throws DdemlUtil.DdemlException {
/*  667 */       Ddeml.HSZ hSZ = null;
/*      */       try {
/*  669 */         hSZ = createStringHandle(param1String);
/*  670 */         nameService(hSZ, param1Int);
/*      */       } finally {
/*  672 */         freeStringHandle(hSZ);
/*      */       } 
/*      */     }
/*      */     
/*      */     public int getLastError() {
/*  677 */       return Ddeml.INSTANCE.DdeGetLastError(this.idInst.intValue());
/*      */     }
/*      */     
/*      */     public DdemlUtil.IDdeConnection connect(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  681 */       Ddeml.HCONV hCONV = Ddeml.INSTANCE.DdeConnect(this.idInst.intValue(), param1HSZ1, param1HSZ2, param1CONVCONTEXT);
/*  682 */       if (hCONV == null) {
/*  683 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  685 */       return new DdemlUtil.DdeConnection(this, hCONV);
/*      */     }
/*      */     
/*      */     public DdemlUtil.IDdeConnection connect(String param1String1, String param1String2, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  689 */       Ddeml.HSZ hSZ1 = null;
/*  690 */       Ddeml.HSZ hSZ2 = null;
/*      */       try {
/*  692 */         hSZ1 = createStringHandle(param1String1);
/*  693 */         hSZ2 = createStringHandle(param1String2);
/*  694 */         return connect(hSZ1, hSZ2, param1CONVCONTEXT);
/*      */       } finally {
/*  696 */         freeStringHandle(hSZ2);
/*  697 */         freeStringHandle(hSZ1);
/*      */       } 
/*      */     }
/*      */     
/*      */     public String queryString(Ddeml.HSZ param1HSZ) throws DdemlUtil.DdemlException {
/*      */       char c;
/*      */       byte b;
/*  704 */       if (W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS) {
/*  705 */         c = 'Ұ';
/*  706 */         b = 2;
/*      */       } else {
/*  708 */         c = 'Ϭ';
/*  709 */         b = 1;
/*      */       } 
/*  711 */       Memory memory = new Memory((257 * b));
/*      */       try {
/*  713 */         int i = Ddeml.INSTANCE.DdeQueryString(this.idInst.intValue(), param1HSZ, (Pointer)memory, 256, c);
/*  714 */         if (W32APIOptions.DEFAULT_OPTIONS == W32APIOptions.UNICODE_OPTIONS) {
/*  715 */           return memory.getWideString(0L);
/*      */         }
/*  717 */         return memory.getString(0L);
/*      */       } finally {
/*      */         
/*  720 */         memory.valid();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Ddeml.HDDEDATA createDataHandle(Pointer param1Pointer, int param1Int1, int param1Int2, Ddeml.HSZ param1HSZ, int param1Int3, int param1Int4) {
/*  726 */       Ddeml.HDDEDATA hDDEDATA = Ddeml.INSTANCE.DdeCreateDataHandle(this.idInst.intValue(), param1Pointer, param1Int1, param1Int2, param1HSZ, param1Int3, param1Int4);
/*  727 */       if (hDDEDATA == null) {
/*  728 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  730 */       return hDDEDATA;
/*      */     }
/*      */     
/*      */     public void freeDataHandle(Ddeml.HDDEDATA param1HDDEDATA) {
/*  734 */       boolean bool = Ddeml.INSTANCE.DdeFreeDataHandle(param1HDDEDATA);
/*  735 */       if (!bool) {
/*  736 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public Ddeml.HDDEDATA addData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2) {
/*  741 */       Ddeml.HDDEDATA hDDEDATA = Ddeml.INSTANCE.DdeAddData(param1HDDEDATA, param1Pointer, param1Int1, param1Int2);
/*  742 */       if (hDDEDATA == null) {
/*  743 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  745 */       return hDDEDATA;
/*      */     }
/*      */     
/*      */     public int getData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2) {
/*  749 */       int i = Ddeml.INSTANCE.DdeGetData(param1HDDEDATA, param1Pointer, param1Int1, param1Int2);
/*  750 */       int j = getLastError();
/*  751 */       if (j != 0) {
/*  752 */         throw DdemlUtil.DdemlException.create(j);
/*      */       }
/*  754 */       return i;
/*      */     }
/*      */     
/*      */     public Pointer accessData(Ddeml.HDDEDATA param1HDDEDATA, WinDef.DWORDByReference param1DWORDByReference) {
/*  758 */       Pointer pointer = Ddeml.INSTANCE.DdeAccessData(param1HDDEDATA, param1DWORDByReference);
/*  759 */       if (pointer == null) {
/*  760 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  762 */       return pointer;
/*      */     }
/*      */     
/*      */     public void unaccessData(Ddeml.HDDEDATA param1HDDEDATA) {
/*  766 */       boolean bool = Ddeml.INSTANCE.DdeUnaccessData(param1HDDEDATA);
/*  767 */       if (!bool) {
/*  768 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void postAdvise(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/*  773 */       boolean bool = Ddeml.INSTANCE.DdePostAdvise(this.idInst.intValue(), param1HSZ1, param1HSZ2);
/*  774 */       if (!bool) {
/*  775 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public void postAdvise(String param1String1, String param1String2) {
/*  780 */       Ddeml.HSZ hSZ1 = null;
/*  781 */       Ddeml.HSZ hSZ2 = null;
/*      */       try {
/*  783 */         hSZ2 = createStringHandle(param1String1);
/*  784 */         hSZ1 = createStringHandle(param1String2);
/*  785 */         postAdvise(hSZ2, hSZ1);
/*      */       } finally {
/*  787 */         freeStringHandle(hSZ2);
/*  788 */         freeStringHandle(hSZ1);
/*      */       } 
/*      */     }
/*      */     
/*      */     public boolean freeStringHandle(Ddeml.HSZ param1HSZ) {
/*  793 */       if (param1HSZ == null) {
/*  794 */         return true;
/*      */       }
/*  796 */       return Ddeml.INSTANCE.DdeFreeStringHandle(this.idInst.intValue(), param1HSZ);
/*      */     }
/*      */     
/*      */     public boolean keepStringHandle(Ddeml.HSZ param1HSZ) {
/*  800 */       return Ddeml.INSTANCE.DdeKeepStringHandle(this.idInst.intValue(), param1HSZ);
/*      */     }
/*      */     
/*      */     public void abandonTransactions() {
/*  804 */       boolean bool = Ddeml.INSTANCE.DdeAbandonTransaction(this.idInst.intValue(), null, 0);
/*  805 */       if (!bool) {
/*  806 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*      */     }
/*      */     
/*      */     public DdemlUtil.IDdeConnectionList connectList(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  811 */       Ddeml.HCONVLIST hCONVLIST = Ddeml.INSTANCE.DdeConnectList(this.idInst.intValue(), param1HSZ1, param1HSZ2, (param1IDdeConnectionList != null) ? param1IDdeConnectionList.getHandle() : null, param1CONVCONTEXT);
/*  812 */       if (hCONVLIST == null) {
/*  813 */         throw DdemlUtil.DdemlException.create(getLastError());
/*      */       }
/*  815 */       return new DdemlUtil.DdeConnectionList(this, hCONVLIST);
/*      */     }
/*      */ 
/*      */     
/*      */     public DdemlUtil.IDdeConnectionList connectList(String param1String1, String param1String2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT) {
/*  820 */       Ddeml.HSZ hSZ1 = null;
/*  821 */       Ddeml.HSZ hSZ2 = null;
/*      */       try {
/*  823 */         hSZ1 = createStringHandle(param1String1);
/*  824 */         hSZ2 = createStringHandle(param1String2);
/*  825 */         return connectList(hSZ1, hSZ2, param1IDdeConnectionList, param1CONVCONTEXT);
/*      */       } finally {
/*  827 */         freeStringHandle(hSZ2);
/*  828 */         freeStringHandle(hSZ1);
/*      */       } 
/*      */     }
/*      */     
/*      */     public boolean enableCallback(int param1Int) {
/*  833 */       boolean bool = Ddeml.INSTANCE.DdeEnableCallback(this.idInst.intValue(), null, param1Int);
/*  834 */       if (!bool && param1Int != 2) {
/*  835 */         int i = getLastError();
/*  836 */         if (i != 0) {
/*  837 */           throw DdemlUtil.DdemlException.create(getLastError());
/*      */         }
/*      */       } 
/*  840 */       return bool;
/*      */     }
/*      */     
/*      */     public boolean uninitialize() {
/*  844 */       return Ddeml.INSTANCE.DdeUninitialize(this.idInst.intValue());
/*      */     }
/*      */     
/*      */     public void close() {
/*  848 */       uninitialize();
/*      */     }
/*      */     
/*      */     public DdemlUtil.IDdeConnection wrap(Ddeml.HCONV param1HCONV) {
/*  852 */       return new DdemlUtil.DdeConnection(this, param1HCONV);
/*      */     }
/*      */ 
/*      */     
/*      */     public void unregisterDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/*  857 */       this.ddeAdapter.unregisterDisconnectHandler(param1DisconnectHandler);
/*      */     }
/*      */     
/*      */     public void registerAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/*  861 */       this.ddeAdapter.registerAdvstartHandler(param1AdvstartHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/*  865 */       this.ddeAdapter.unregisterAdvstartHandler(param1AdvstartHandler);
/*      */     }
/*      */     
/*      */     public void registerAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/*  869 */       this.ddeAdapter.registerAdvstopHandler(param1AdvstopHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/*  873 */       this.ddeAdapter.unregisterAdvstopHandler(param1AdvstopHandler);
/*      */     }
/*      */     
/*      */     public void registerConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/*  877 */       this.ddeAdapter.registerConnectHandler(param1ConnectHandler);
/*      */     }
/*      */     
/*      */     public void unregisterConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/*  881 */       this.ddeAdapter.unregisterConnectHandler(param1ConnectHandler);
/*      */     }
/*      */     
/*      */     public void registerAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/*  885 */       this.ddeAdapter.registerAdvReqHandler(param1AdvreqHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/*  889 */       this.ddeAdapter.unregisterAdvReqHandler(param1AdvreqHandler);
/*      */     }
/*      */     
/*      */     public void registerRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/*  893 */       this.ddeAdapter.registerRequestHandler(param1RequestHandler);
/*      */     }
/*      */     
/*      */     public void unregisterRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/*  897 */       this.ddeAdapter.unregisterRequestHandler(param1RequestHandler);
/*      */     }
/*      */     
/*      */     public void registerWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/*  901 */       this.ddeAdapter.registerWildconnectHandler(param1WildconnectHandler);
/*      */     }
/*      */     
/*      */     public void unregisterWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/*  905 */       this.ddeAdapter.unregisterWildconnectHandler(param1WildconnectHandler);
/*      */     }
/*      */     
/*      */     public void registerAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/*  909 */       this.ddeAdapter.registerAdvdataHandler(param1AdvdataHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/*  913 */       this.ddeAdapter.unregisterAdvdataHandler(param1AdvdataHandler);
/*      */     }
/*      */     
/*      */     public void registerExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/*  917 */       this.ddeAdapter.registerExecuteHandler(param1ExecuteHandler);
/*      */     }
/*      */     
/*      */     public void unregisterExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/*  921 */       this.ddeAdapter.unregisterExecuteHandler(param1ExecuteHandler);
/*      */     }
/*      */     
/*      */     public void registerPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/*  925 */       this.ddeAdapter.registerPokeHandler(param1PokeHandler);
/*      */     }
/*      */     
/*      */     public void unregisterPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/*  929 */       this.ddeAdapter.unregisterPokeHandler(param1PokeHandler);
/*      */     }
/*      */     
/*      */     public void registerConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/*  933 */       this.ddeAdapter.registerConnectConfirmHandler(param1ConnectConfirmHandler);
/*      */     }
/*      */     
/*      */     public void unregisterConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/*  937 */       this.ddeAdapter.unregisterConnectConfirmHandler(param1ConnectConfirmHandler);
/*      */     }
/*      */     
/*      */     public void registerDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/*  941 */       this.ddeAdapter.registerDisconnectHandler(param1DisconnectHandler);
/*      */     }
/*      */     
/*      */     public void registerErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/*  945 */       this.ddeAdapter.registerErrorHandler(param1ErrorHandler);
/*      */     }
/*      */     
/*      */     public void unregisterErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/*  949 */       this.ddeAdapter.unregisterErrorHandler(param1ErrorHandler);
/*      */     }
/*      */     
/*      */     public void registerRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/*  953 */       this.ddeAdapter.registerRegisterHandler(param1RegisterHandler);
/*      */     }
/*      */     
/*      */     public void unregisterRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/*  957 */       this.ddeAdapter.unregisterRegisterHandler(param1RegisterHandler);
/*      */     }
/*      */     
/*      */     public void registerXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/*  961 */       this.ddeAdapter.registerXactCompleteHandler(param1XactCompleteHandler);
/*      */     }
/*      */     
/*      */     public void unregisterXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/*  965 */       this.ddeAdapter.xactCompleteXactCompleteHandler(param1XactCompleteHandler);
/*      */     }
/*      */     
/*      */     public void registerUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/*  969 */       this.ddeAdapter.registerUnregisterHandler(param1UnregisterHandler);
/*      */     }
/*      */     
/*      */     public void unregisterUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/*  973 */       this.ddeAdapter.unregisterUnregisterHandler(param1UnregisterHandler);
/*      */     }
/*      */     
/*      */     public void registerMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/*  977 */       this.ddeAdapter.registerMonitorHandler(param1MonitorHandler);
/*      */     }
/*      */     
/*      */     public void unregisterMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/*  981 */       this.ddeAdapter.unregisterMonitorHandler(param1MonitorHandler);
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
/*      */   public static interface AdvstartHandler
/*      */   {
/*      */     boolean onAdvstart(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
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
/*      */   public static interface AdvstopHandler
/*      */   {
/*      */     void onAdvstop(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
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
/*      */   public static interface ConnectHandler
/*      */   {
/*      */     boolean onConnect(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT, boolean param1Boolean);
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
/*      */   public static interface AdvreqHandler
/*      */   {
/*      */     Ddeml.HDDEDATA onAdvreq(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, int param1Int3);
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
/*      */   public static interface RequestHandler
/*      */   {
/*      */     Ddeml.HDDEDATA onRequest(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
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
/*      */   public static interface WildconnectHandler
/*      */   {
/*      */     List<Ddeml.HSZPAIR> onWildconnect(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT, boolean param1Boolean);
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
/*      */   public static interface AdvdataHandler
/*      */   {
/*      */     int onAdvdata(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA);
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
/*      */   public static interface ConnectConfirmHandler
/*      */   {
/*      */     void onConnectConfirm(int param1Int, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, boolean param1Boolean);
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
/*      */   public static interface DisconnectHandler
/*      */   {
/*      */     void onDisconnect(int param1Int, Ddeml.HCONV param1HCONV, boolean param1Boolean);
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
/*      */   public static interface ErrorHandler
/*      */   {
/*      */     void onError(int param1Int1, Ddeml.HCONV param1HCONV, int param1Int2);
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
/*      */   public static interface RegisterHandler
/*      */   {
/*      */     void onRegister(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
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
/*      */   public static interface XactCompleteHandler
/*      */   {
/*      */     void onXactComplete(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA, BaseTSD.ULONG_PTR param1ULONG_PTR1, BaseTSD.ULONG_PTR param1ULONG_PTR2);
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
/*      */   public static interface UnregisterHandler
/*      */   {
/*      */     void onUnregister(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
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
/*      */   public static interface ExecuteHandler
/*      */   {
/*      */     int onExecute(int param1Int, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ, Ddeml.HDDEDATA param1HDDEDATA);
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
/*      */   public static interface PokeHandler
/*      */   {
/*      */     int onPoke(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA);
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
/*      */   public static interface MonitorHandler
/*      */   {
/*      */     void onMonitor(int param1Int1, Ddeml.HDDEDATA param1HDDEDATA, int param1Int2);
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
/*      */   public static class DdeAdapter
/*      */     implements Ddeml.DdeCallback
/*      */   {
/*      */     public static class BlockException
/*      */       extends RuntimeException {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1535 */     private static final Logger LOG = Logger.getLogger(DdeAdapter.class.getName());
/*      */     
/*      */     private int idInst;
/*      */     
/*      */     public void setInstanceIdentifier(int param1Int) {
/* 1540 */       this.idInst = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WinDef.PVOID ddeCallback(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA, BaseTSD.ULONG_PTR param1ULONG_PTR1, BaseTSD.ULONG_PTR param1ULONG_PTR2) {
/* 1548 */       Object object = null; 
/*      */       try { boolean bool; Ddeml.HDDEDATA hDDEDATA; Ddeml.CONVCONTEXT cONVCONTEXT; int i, j; Ddeml.HSZPAIR[] arrayOfHSZPAIR; int k;
/* 1550 */         switch (param1Int1)
/*      */         { case 4144:
/* 1552 */             bool = onAdvstart(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2);
/* 1553 */             return new WinDef.PVOID(Pointer.createConstant((new WinDef.BOOL(bool)).intValue()));
/*      */           case 4194:
/* 1555 */             cONVCONTEXT = null;
/* 1556 */             if (param1ULONG_PTR1.toPointer() != null) {
/* 1557 */               cONVCONTEXT = new Ddeml.CONVCONTEXT(new Pointer(param1ULONG_PTR1.longValue()));
/*      */             }
/* 1559 */             bool = onConnect(param1Int1, param1HSZ1, param1HSZ2, cONVCONTEXT, (param1ULONG_PTR2 != null && param1ULONG_PTR2.intValue() != 0));
/* 1560 */             return new WinDef.PVOID(Pointer.createConstant((new WinDef.BOOL(bool)).intValue()));
/*      */           case 8226:
/* 1562 */             j = param1ULONG_PTR1.intValue() & 0xFFFF;
/* 1563 */             hDDEDATA = onAdvreq(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, j);
/* 1564 */             if (hDDEDATA == null) {
/* 1565 */               return new WinDef.PVOID();
/*      */             }
/* 1567 */             return new WinDef.PVOID(hDDEDATA.getPointer());
/*      */           
/*      */           case 8368:
/* 1570 */             hDDEDATA = onRequest(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2);
/* 1571 */             if (hDDEDATA == null) {
/* 1572 */               return new WinDef.PVOID();
/*      */             }
/* 1574 */             return new WinDef.PVOID(hDDEDATA.getPointer());
/*      */           
/*      */           case 8418:
/* 1577 */             cONVCONTEXT = null;
/* 1578 */             if (param1ULONG_PTR1.toPointer() != null) {
/* 1579 */               cONVCONTEXT = new Ddeml.CONVCONTEXT(new Pointer(param1ULONG_PTR1.longValue()));
/*      */             }
/* 1581 */             arrayOfHSZPAIR = onWildconnect(param1Int1, param1HSZ1, param1HSZ2, cONVCONTEXT, (param1ULONG_PTR2 != null && param1ULONG_PTR2.intValue() != 0));
/* 1582 */             if (arrayOfHSZPAIR == null || arrayOfHSZPAIR.length == 0) {
/* 1583 */               return new WinDef.PVOID();
/*      */             }
/* 1585 */             k = 0;
/* 1586 */             for (Ddeml.HSZPAIR hSZPAIR : arrayOfHSZPAIR) {
/* 1587 */               hSZPAIR.write();
/* 1588 */               k += hSZPAIR.size();
/*      */             } 
/* 1590 */             hDDEDATA = Ddeml.INSTANCE.DdeCreateDataHandle(this.idInst, arrayOfHSZPAIR[0]
/* 1591 */                 .getPointer(), k, 0, null, param1Int2, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1597 */             return new WinDef.PVOID(hDDEDATA.getPointer());
/*      */           case 16400:
/* 1599 */             i = onAdvdata(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA);
/* 1600 */             return new WinDef.PVOID(Pointer.createConstant(i));
/*      */           case 16464:
/* 1602 */             i = onExecute(param1Int1, param1HCONV, param1HSZ1, param1HDDEDATA);
/* 1603 */             Ddeml.INSTANCE.DdeFreeDataHandle(param1HDDEDATA);
/* 1604 */             return new WinDef.PVOID(Pointer.createConstant(i));
/*      */           case 16528:
/* 1606 */             i = onPoke(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA);
/* 1607 */             return new WinDef.PVOID(Pointer.createConstant(i));
/*      */           case 32832:
/* 1609 */             onAdvstop(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 1640 */             return new WinDef.PVOID();case 32882: onConnectConfirm(param1Int1, param1HCONV, param1HSZ1, param1HSZ2, (param1ULONG_PTR2 != null && param1ULONG_PTR2.intValue() != 0)); return new WinDef.PVOID();case 32962: onDisconnect(param1Int1, param1HCONV, (param1ULONG_PTR2 != null && param1ULONG_PTR2.intValue() != 0)); return new WinDef.PVOID();case 32770: onError(param1Int1, param1HCONV, (int)(param1ULONG_PTR2.longValue() & 0xFFFFL)); return new WinDef.PVOID();case 32930: onRegister(param1Int1, param1HSZ1, param1HSZ2); return new WinDef.PVOID();case 32896: onXactComplete(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA, param1ULONG_PTR1, param1ULONG_PTR2); return new WinDef.PVOID();case 32978: onUnregister(param1Int1, param1HSZ1, param1HSZ2); return new WinDef.PVOID();case 33010: onMonitor(param1Int1, param1HDDEDATA, param1ULONG_PTR2.intValue()); return new WinDef.PVOID(); }  LOG.log(Level.FINE, String.format("Not implemented Operation - Transaction type: 0x%X (%s)", new Object[] { Integer.valueOf(param1Int1), object })); } catch (BlockException blockException) { return new WinDef.PVOID(Pointer.createConstant(-1)); } catch (Throwable throwable) { LOG.log(Level.WARNING, "Exception in DDECallback", throwable); }  return new WinDef.PVOID();
/*      */     }
/*      */     
/* 1643 */     private final List<DdemlUtil.AdvstartHandler> advstartHandler = new CopyOnWriteArrayList<DdemlUtil.AdvstartHandler>();
/*      */     
/*      */     public void registerAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/* 1646 */       this.advstartHandler.add(param1AdvstartHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler) {
/* 1650 */       this.advstartHandler.remove(param1AdvstartHandler);
/*      */     }
/*      */     
/*      */     private boolean onAdvstart(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/* 1654 */       boolean bool = false;
/* 1655 */       for (DdemlUtil.AdvstartHandler advstartHandler : this.advstartHandler) {
/* 1656 */         if (advstartHandler.onAdvstart(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2)) {
/* 1657 */           bool = true;
/*      */         }
/*      */       } 
/* 1660 */       return bool;
/*      */     }
/*      */     
/* 1663 */     private final List<DdemlUtil.AdvstopHandler> advstopHandler = new CopyOnWriteArrayList<DdemlUtil.AdvstopHandler>();
/*      */     
/*      */     public void registerAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/* 1666 */       this.advstopHandler.add(param1AdvstopHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler) {
/* 1670 */       this.advstopHandler.remove(param1AdvstopHandler);
/*      */     }
/*      */     
/*      */     private void onAdvstop(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/* 1674 */       for (DdemlUtil.AdvstopHandler advstopHandler : this.advstopHandler) {
/* 1675 */         advstopHandler.onAdvstop(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2);
/*      */       }
/*      */     }
/*      */     
/* 1679 */     private final List<DdemlUtil.ConnectHandler> connectHandler = new CopyOnWriteArrayList<DdemlUtil.ConnectHandler>();
/*      */     
/*      */     public void registerConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/* 1682 */       this.connectHandler.add(param1ConnectHandler);
/*      */     }
/*      */     
/*      */     public void unregisterConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler) {
/* 1686 */       this.connectHandler.remove(param1ConnectHandler);
/*      */     }
/*      */     
/*      */     private boolean onConnect(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT, boolean param1Boolean) {
/* 1690 */       boolean bool = false;
/* 1691 */       for (DdemlUtil.ConnectHandler connectHandler : this.connectHandler) {
/* 1692 */         if (connectHandler.onConnect(param1Int, param1HSZ1, param1HSZ2, param1CONVCONTEXT, param1Boolean)) {
/* 1693 */           bool = true;
/*      */         }
/*      */       } 
/* 1696 */       return bool;
/*      */     }
/*      */     
/* 1699 */     private final List<DdemlUtil.AdvreqHandler> advReqHandler = new CopyOnWriteArrayList<DdemlUtil.AdvreqHandler>();
/*      */     
/*      */     public void registerAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/* 1702 */       this.advReqHandler.add(param1AdvreqHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler) {
/* 1706 */       this.advReqHandler.remove(param1AdvreqHandler);
/*      */     }
/*      */     
/*      */     private Ddeml.HDDEDATA onAdvreq(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, int param1Int3) {
/* 1710 */       for (DdemlUtil.AdvreqHandler advreqHandler : this.advReqHandler) {
/* 1711 */         Ddeml.HDDEDATA hDDEDATA = advreqHandler.onAdvreq(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1Int3);
/* 1712 */         if (hDDEDATA != null) {
/* 1713 */           return hDDEDATA;
/*      */         }
/*      */       } 
/* 1716 */       return null;
/*      */     }
/*      */     
/* 1719 */     private final List<DdemlUtil.RequestHandler> requestHandler = new CopyOnWriteArrayList<DdemlUtil.RequestHandler>();
/*      */     
/*      */     public void registerRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/* 1722 */       this.requestHandler.add(param1RequestHandler);
/*      */     }
/*      */     
/*      */     public void unregisterRequestHandler(DdemlUtil.RequestHandler param1RequestHandler) {
/* 1726 */       this.requestHandler.remove(param1RequestHandler);
/*      */     }
/*      */     
/*      */     private Ddeml.HDDEDATA onRequest(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/* 1730 */       for (DdemlUtil.RequestHandler requestHandler : this.requestHandler) {
/* 1731 */         Ddeml.HDDEDATA hDDEDATA = requestHandler.onRequest(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2);
/* 1732 */         if (hDDEDATA != null) {
/* 1733 */           return hDDEDATA;
/*      */         }
/*      */       } 
/* 1736 */       return null;
/*      */     }
/*      */     
/* 1739 */     private final List<DdemlUtil.WildconnectHandler> wildconnectHandler = new CopyOnWriteArrayList<DdemlUtil.WildconnectHandler>();
/*      */     
/*      */     public void registerWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/* 1742 */       this.wildconnectHandler.add(param1WildconnectHandler);
/*      */     }
/*      */     
/*      */     public void unregisterWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler) {
/* 1746 */       this.wildconnectHandler.remove(param1WildconnectHandler);
/*      */     }
/*      */     
/*      */     private Ddeml.HSZPAIR[] onWildconnect(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT, boolean param1Boolean) {
/* 1750 */       ArrayList<Ddeml.HSZPAIR> arrayList = new ArrayList(1);
/* 1751 */       for (DdemlUtil.WildconnectHandler wildconnectHandler : this.wildconnectHandler) {
/* 1752 */         arrayList.addAll(wildconnectHandler.onWildconnect(param1Int, param1HSZ1, param1HSZ2, param1CONVCONTEXT, param1Boolean));
/*      */       }
/* 1754 */       return arrayList.<Ddeml.HSZPAIR>toArray(new Ddeml.HSZPAIR[0]);
/*      */     }
/*      */ 
/*      */     
/* 1758 */     private final List<DdemlUtil.AdvdataHandler> advdataHandler = new CopyOnWriteArrayList<DdemlUtil.AdvdataHandler>();
/*      */     
/*      */     public void registerAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/* 1761 */       this.advdataHandler.add(param1AdvdataHandler);
/*      */     }
/*      */     
/*      */     public void unregisterAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler) {
/* 1765 */       this.advdataHandler.remove(param1AdvdataHandler);
/*      */     }
/*      */     
/*      */     private int onAdvdata(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA) {
/* 1769 */       for (DdemlUtil.AdvdataHandler advdataHandler : this.advdataHandler) {
/* 1770 */         int i = advdataHandler.onAdvdata(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA);
/* 1771 */         if (i != 0) {
/* 1772 */           return i;
/*      */         }
/*      */       } 
/* 1775 */       return 0;
/*      */     }
/*      */     
/* 1778 */     private final List<DdemlUtil.ExecuteHandler> executeHandler = new CopyOnWriteArrayList<DdemlUtil.ExecuteHandler>();
/*      */     
/*      */     public void registerExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/* 1781 */       this.executeHandler.add(param1ExecuteHandler);
/*      */     }
/*      */     
/*      */     public void unregisterExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler) {
/* 1785 */       this.executeHandler.remove(param1ExecuteHandler);
/*      */     }
/*      */     
/*      */     private int onExecute(int param1Int, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ, Ddeml.HDDEDATA param1HDDEDATA) {
/* 1789 */       for (DdemlUtil.ExecuteHandler executeHandler : this.executeHandler) {
/* 1790 */         int i = executeHandler.onExecute(param1Int, param1HCONV, param1HSZ, param1HDDEDATA);
/* 1791 */         if (i != 0) {
/* 1792 */           return i;
/*      */         }
/*      */       } 
/* 1795 */       return 0;
/*      */     }
/*      */     
/* 1798 */     private final List<DdemlUtil.PokeHandler> pokeHandler = new CopyOnWriteArrayList<DdemlUtil.PokeHandler>();
/*      */     
/*      */     public void registerPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/* 1801 */       this.pokeHandler.add(param1PokeHandler);
/*      */     }
/*      */     
/*      */     public void unregisterPokeHandler(DdemlUtil.PokeHandler param1PokeHandler) {
/* 1805 */       this.pokeHandler.remove(param1PokeHandler);
/*      */     }
/*      */     
/*      */     private int onPoke(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA) {
/* 1809 */       for (DdemlUtil.PokeHandler pokeHandler : this.pokeHandler) {
/* 1810 */         int i = pokeHandler.onPoke(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA);
/* 1811 */         if (i != 0) {
/* 1812 */           return i;
/*      */         }
/*      */       } 
/* 1815 */       return 0;
/*      */     }
/*      */     
/* 1818 */     private final List<DdemlUtil.ConnectConfirmHandler> connectConfirmHandler = new CopyOnWriteArrayList<DdemlUtil.ConnectConfirmHandler>();
/*      */     
/*      */     public void registerConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/* 1821 */       this.connectConfirmHandler.add(param1ConnectConfirmHandler);
/*      */     }
/*      */     
/*      */     public void unregisterConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler) {
/* 1825 */       this.connectConfirmHandler.remove(param1ConnectConfirmHandler);
/*      */     }
/*      */     
/*      */     private void onConnectConfirm(int param1Int, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, boolean param1Boolean) {
/* 1829 */       for (DdemlUtil.ConnectConfirmHandler connectConfirmHandler : this.connectConfirmHandler) {
/* 1830 */         connectConfirmHandler.onConnectConfirm(param1Int, param1HCONV, param1HSZ1, param1HSZ2, param1Boolean);
/*      */       }
/*      */     }
/*      */     
/* 1834 */     private final List<DdemlUtil.DisconnectHandler> disconnectHandler = new CopyOnWriteArrayList<DdemlUtil.DisconnectHandler>();
/*      */     
/*      */     public void registerDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/* 1837 */       this.disconnectHandler.add(param1DisconnectHandler);
/*      */     }
/*      */     
/*      */     public void unregisterDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler) {
/* 1841 */       this.disconnectHandler.remove(param1DisconnectHandler);
/*      */     }
/*      */     
/*      */     private void onDisconnect(int param1Int, Ddeml.HCONV param1HCONV, boolean param1Boolean) {
/* 1845 */       for (DdemlUtil.DisconnectHandler disconnectHandler : this.disconnectHandler) {
/* 1846 */         disconnectHandler.onDisconnect(param1Int, param1HCONV, param1Boolean);
/*      */       }
/*      */     }
/*      */     
/* 1850 */     private final List<DdemlUtil.ErrorHandler> errorHandler = new CopyOnWriteArrayList<DdemlUtil.ErrorHandler>();
/*      */     
/*      */     public void registerErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/* 1853 */       this.errorHandler.add(param1ErrorHandler);
/*      */     }
/*      */     
/*      */     public void unregisterErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler) {
/* 1857 */       this.errorHandler.remove(param1ErrorHandler);
/*      */     }
/*      */     
/*      */     private void onError(int param1Int1, Ddeml.HCONV param1HCONV, int param1Int2) {
/* 1861 */       for (DdemlUtil.ErrorHandler errorHandler : this.errorHandler) {
/* 1862 */         errorHandler.onError(param1Int1, param1HCONV, param1Int2);
/*      */       }
/*      */     }
/*      */     
/* 1866 */     private final List<DdemlUtil.RegisterHandler> registerHandler = new CopyOnWriteArrayList<DdemlUtil.RegisterHandler>();
/*      */     
/*      */     public void registerRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/* 1869 */       this.registerHandler.add(param1RegisterHandler);
/*      */     }
/*      */     
/*      */     public void unregisterRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler) {
/* 1873 */       this.registerHandler.remove(param1RegisterHandler);
/*      */     }
/*      */     
/*      */     private void onRegister(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/* 1877 */       for (DdemlUtil.RegisterHandler registerHandler : this.registerHandler) {
/* 1878 */         registerHandler.onRegister(param1Int, param1HSZ1, param1HSZ2);
/*      */       }
/*      */     }
/*      */     
/* 1882 */     private final List<DdemlUtil.XactCompleteHandler> xactCompleteHandler = new CopyOnWriteArrayList<DdemlUtil.XactCompleteHandler>();
/*      */     
/*      */     public void registerXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/* 1885 */       this.xactCompleteHandler.add(param1XactCompleteHandler);
/*      */     }
/*      */     
/*      */     public void xactCompleteXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler) {
/* 1889 */       this.xactCompleteHandler.remove(param1XactCompleteHandler);
/*      */     }
/*      */     
/*      */     private void onXactComplete(int param1Int1, int param1Int2, Ddeml.HCONV param1HCONV, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.HDDEDATA param1HDDEDATA, BaseTSD.ULONG_PTR param1ULONG_PTR1, BaseTSD.ULONG_PTR param1ULONG_PTR2) {
/* 1893 */       for (DdemlUtil.XactCompleteHandler xactCompleteHandler : this.xactCompleteHandler) {
/* 1894 */         xactCompleteHandler.onXactComplete(param1Int1, param1Int2, param1HCONV, param1HSZ1, param1HSZ2, param1HDDEDATA, param1ULONG_PTR1, param1ULONG_PTR2);
/*      */       }
/*      */     }
/*      */     
/* 1898 */     private final List<DdemlUtil.UnregisterHandler> unregisterHandler = new CopyOnWriteArrayList<DdemlUtil.UnregisterHandler>();
/*      */     
/*      */     public void registerUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/* 1901 */       this.unregisterHandler.add(param1UnregisterHandler);
/*      */     }
/*      */     
/*      */     public void unregisterUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler) {
/* 1905 */       this.unregisterHandler.remove(param1UnregisterHandler);
/*      */     }
/*      */     
/*      */     private void onUnregister(int param1Int, Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2) {
/* 1909 */       for (DdemlUtil.UnregisterHandler unregisterHandler : this.unregisterHandler) {
/* 1910 */         unregisterHandler.onUnregister(param1Int, param1HSZ1, param1HSZ2);
/*      */       }
/*      */     }
/*      */     
/* 1914 */     private final List<DdemlUtil.MonitorHandler> monitorHandler = new CopyOnWriteArrayList<DdemlUtil.MonitorHandler>();
/*      */     
/*      */     public void registerMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/* 1917 */       this.monitorHandler.add(param1MonitorHandler);
/*      */     }
/*      */     
/*      */     public void unregisterMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler) {
/* 1921 */       this.monitorHandler.remove(param1MonitorHandler);
/*      */     }
/*      */     
/*      */     private void onMonitor(int param1Int1, Ddeml.HDDEDATA param1HDDEDATA, int param1Int2) {
/* 1925 */       for (DdemlUtil.MonitorHandler monitorHandler : this.monitorHandler) {
/* 1926 */         monitorHandler.onMonitor(param1Int1, param1HDDEDATA, param1Int2);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class DdemlException
/*      */     extends RuntimeException
/*      */   {
/*      */     private static final Map<Integer, String> ERROR_CODE_MAP;
/*      */     private final int errorCode;
/*      */     
/*      */     static {
/* 1939 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1940 */       for (Field field : Ddeml.class.getFields()) {
/* 1941 */         String str = field.getName();
/* 1942 */         if (str.startsWith("DMLERR_") && !str.equals("DMLERR_FIRST") && !str.equals("DMLERR_LAST")) {
/*      */           try {
/* 1944 */             hashMap.put(Integer.valueOf(field.getInt(null)), str);
/* 1945 */           } catch (IllegalArgumentException illegalArgumentException) {
/* 1946 */             throw new RuntimeException(illegalArgumentException);
/* 1947 */           } catch (IllegalAccessException illegalAccessException) {
/* 1948 */             throw new RuntimeException(illegalAccessException);
/*      */           } 
/*      */         }
/*      */       } 
/* 1952 */       ERROR_CODE_MAP = Collections.unmodifiableMap(hashMap);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static DdemlException create(int param1Int) {
/* 1958 */       String str = ERROR_CODE_MAP.get(Integer.valueOf(param1Int));
/* 1959 */       return new DdemlException(param1Int, String.format("%s (Code: 0x%X)", new Object[] { (str != null) ? str : "", 
/*      */               
/* 1961 */               Integer.valueOf(param1Int) }));
/*      */     }
/*      */     
/*      */     public DdemlException(int param1Int, String param1String) {
/* 1965 */       super(param1String);
/* 1966 */       this.errorCode = param1Int;
/*      */     }
/*      */     
/*      */     public int getErrorCode() {
/* 1970 */       return this.errorCode;
/*      */     }
/*      */   }
/*      */   
/*      */   public static interface IDdeConnection extends Closeable {
/*      */     Ddeml.HCONV getConv();
/*      */     
/*      */     void execute(String param1String, int param1Int, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void poke(Pointer param1Pointer, int param1Int1, Ddeml.HSZ param1HSZ, int param1Int2, int param1Int3, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void poke(Pointer param1Pointer, int param1Int1, String param1String, int param1Int2, int param1Int3, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     Ddeml.HDDEDATA request(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     Ddeml.HDDEDATA request(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     Ddeml.HDDEDATA clientTransaction(Pointer param1Pointer, int param1Int1, Ddeml.HSZ param1HSZ, int param1Int2, int param1Int3, int param1Int4, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     Ddeml.HDDEDATA clientTransaction(Pointer param1Pointer, int param1Int1, String param1String, int param1Int2, int param1Int3, int param1Int4, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void advstart(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void advstart(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void advstop(Ddeml.HSZ param1HSZ, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void advstop(String param1String, int param1Int1, int param1Int2, WinDef.DWORDByReference param1DWORDByReference, BaseTSD.DWORD_PTR param1DWORD_PTR);
/*      */     
/*      */     void abandonTransaction(int param1Int);
/*      */     
/*      */     void abandonTransactions();
/*      */     
/*      */     void impersonateClient();
/*      */     
/*      */     void close();
/*      */     
/*      */     void reconnect();
/*      */     
/*      */     boolean enableCallback(int param1Int);
/*      */     
/*      */     void setUserHandle(int param1Int, BaseTSD.DWORD_PTR param1DWORD_PTR) throws DdemlUtil.DdemlException;
/*      */     
/*      */     Ddeml.CONVINFO queryConvInfo(int param1Int) throws DdemlUtil.DdemlException;
/*      */   }
/*      */   
/*      */   public static interface IDdeClient extends Closeable {
/*      */     Integer getInstanceIdentitifier();
/*      */     
/*      */     void initialize(int param1Int) throws DdemlUtil.DdemlException;
/*      */     
/*      */     Ddeml.HSZ createStringHandle(String param1String) throws DdemlUtil.DdemlException;
/*      */     
/*      */     String queryString(Ddeml.HSZ param1HSZ) throws DdemlUtil.DdemlException;
/*      */     
/*      */     boolean freeStringHandle(Ddeml.HSZ param1HSZ);
/*      */     
/*      */     boolean keepStringHandle(Ddeml.HSZ param1HSZ);
/*      */     
/*      */     void nameService(Ddeml.HSZ param1HSZ, int param1Int) throws DdemlUtil.DdemlException;
/*      */     
/*      */     void nameService(String param1String, int param1Int) throws DdemlUtil.DdemlException;
/*      */     
/*      */     int getLastError();
/*      */     
/*      */     DdemlUtil.IDdeConnection connect(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, Ddeml.CONVCONTEXT param1CONVCONTEXT);
/*      */     
/*      */     DdemlUtil.IDdeConnection connect(String param1String1, String param1String2, Ddeml.CONVCONTEXT param1CONVCONTEXT);
/*      */     
/*      */     Ddeml.HDDEDATA createDataHandle(Pointer param1Pointer, int param1Int1, int param1Int2, Ddeml.HSZ param1HSZ, int param1Int3, int param1Int4);
/*      */     
/*      */     void freeDataHandle(Ddeml.HDDEDATA param1HDDEDATA);
/*      */     
/*      */     Ddeml.HDDEDATA addData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2);
/*      */     
/*      */     int getData(Ddeml.HDDEDATA param1HDDEDATA, Pointer param1Pointer, int param1Int1, int param1Int2);
/*      */     
/*      */     Pointer accessData(Ddeml.HDDEDATA param1HDDEDATA, WinDef.DWORDByReference param1DWORDByReference);
/*      */     
/*      */     void unaccessData(Ddeml.HDDEDATA param1HDDEDATA);
/*      */     
/*      */     void postAdvise(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2);
/*      */     
/*      */     void postAdvise(String param1String1, String param1String2);
/*      */     
/*      */     void abandonTransactions();
/*      */     
/*      */     DdemlUtil.IDdeConnectionList connectList(Ddeml.HSZ param1HSZ1, Ddeml.HSZ param1HSZ2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT);
/*      */     
/*      */     DdemlUtil.IDdeConnectionList connectList(String param1String1, String param1String2, DdemlUtil.IDdeConnectionList param1IDdeConnectionList, Ddeml.CONVCONTEXT param1CONVCONTEXT);
/*      */     
/*      */     boolean enableCallback(int param1Int);
/*      */     
/*      */     boolean uninitialize();
/*      */     
/*      */     DdemlUtil.IDdeConnection wrap(Ddeml.HCONV param1HCONV);
/*      */     
/*      */     void registerAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler);
/*      */     
/*      */     void unregisterAdvstartHandler(DdemlUtil.AdvstartHandler param1AdvstartHandler);
/*      */     
/*      */     void registerAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler);
/*      */     
/*      */     void unregisterAdvstopHandler(DdemlUtil.AdvstopHandler param1AdvstopHandler);
/*      */     
/*      */     void registerConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler);
/*      */     
/*      */     void unregisterConnectHandler(DdemlUtil.ConnectHandler param1ConnectHandler);
/*      */     
/*      */     void registerAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler);
/*      */     
/*      */     void unregisterAdvReqHandler(DdemlUtil.AdvreqHandler param1AdvreqHandler);
/*      */     
/*      */     void registerRequestHandler(DdemlUtil.RequestHandler param1RequestHandler);
/*      */     
/*      */     void unregisterRequestHandler(DdemlUtil.RequestHandler param1RequestHandler);
/*      */     
/*      */     void registerWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler);
/*      */     
/*      */     void unregisterWildconnectHandler(DdemlUtil.WildconnectHandler param1WildconnectHandler);
/*      */     
/*      */     void registerAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler);
/*      */     
/*      */     void unregisterAdvdataHandler(DdemlUtil.AdvdataHandler param1AdvdataHandler);
/*      */     
/*      */     void registerExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler);
/*      */     
/*      */     void unregisterExecuteHandler(DdemlUtil.ExecuteHandler param1ExecuteHandler);
/*      */     
/*      */     void registerPokeHandler(DdemlUtil.PokeHandler param1PokeHandler);
/*      */     
/*      */     void unregisterPokeHandler(DdemlUtil.PokeHandler param1PokeHandler);
/*      */     
/*      */     void registerConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler);
/*      */     
/*      */     void unregisterConnectConfirmHandler(DdemlUtil.ConnectConfirmHandler param1ConnectConfirmHandler);
/*      */     
/*      */     void registerDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler);
/*      */     
/*      */     void unregisterDisconnectHandler(DdemlUtil.DisconnectHandler param1DisconnectHandler);
/*      */     
/*      */     void registerErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler);
/*      */     
/*      */     void unregisterErrorHandler(DdemlUtil.ErrorHandler param1ErrorHandler);
/*      */     
/*      */     void registerRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler);
/*      */     
/*      */     void unregisterRegisterHandler(DdemlUtil.RegisterHandler param1RegisterHandler);
/*      */     
/*      */     void registerXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler);
/*      */     
/*      */     void unregisterXactCompleteHandler(DdemlUtil.XactCompleteHandler param1XactCompleteHandler);
/*      */     
/*      */     void registerUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler);
/*      */     
/*      */     void unregisterUnregisterHandler(DdemlUtil.UnregisterHandler param1UnregisterHandler);
/*      */     
/*      */     void registerMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler);
/*      */     
/*      */     void unregisterMonitorHandler(DdemlUtil.MonitorHandler param1MonitorHandler);
/*      */   }
/*      */   
/*      */   public static interface IDdeConnectionList extends Closeable {
/*      */     Ddeml.HCONVLIST getHandle();
/*      */     
/*      */     DdemlUtil.IDdeConnection queryNextServer(DdemlUtil.IDdeConnection param1IDdeConnection);
/*      */     
/*      */     void close();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\DdemlUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */