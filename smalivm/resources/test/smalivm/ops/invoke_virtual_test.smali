.class public Linvoke_virtual_test;
.super Ljava/lang/Object;

# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static invokeReturnVoid()V
  .locals 1

  invoke-virtual {v0}, Linvoke_virtual_test;->returnVoid()V

  return-void
.end method

.method public static invokeReturnInt()V
  .locals 1

  invoke-virtual {v0}, Linvoke_virtual_test;->returnInt()I

  return-void
.end method

.method public static invokeReturnParameter()V
  .locals 2

  invoke-virtual {v0, v1}, Linvoke_virtual_test;->returnParameter(I)I

  return-void
.end method

.method public static invokeGetComponentType()V
  .locals 1

  const-class v0, [I
  invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

  return-void
.end method

.method public static invokeRangeManyParameters()V
  .locals 8

  # v0 - instance
  # v1 - I
  # v2+v3 - J
  # v4+v5 - J
  # v6+v7 - J
  invoke-virtual/range {v0 .. v7}, Linvoke_virtual_test;->manyParametersReturnsLast(JJJI)I

  return-void
.end method

.method private returnVoid()V
    .locals 0

    return-void
.end method

.method private returnInt()I
    .locals 1

    const/4 v0, 0x7

    return v0
.end method

.method private returnParameter(I)I
    .locals 1

    move v0, p1

    return v0
.end method

.method private manyParametersReturnsLast(JJJI)I
  .locals 0

  return v7
.end method
