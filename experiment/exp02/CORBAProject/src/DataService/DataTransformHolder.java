package DataService;

/**
* DataService/DataTransformHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2020年5月2日 星期六 下午03时24分37秒 CST
*/

public final class DataTransformHolder implements org.omg.CORBA.portable.Streamable
{
  public DataService.DataTransform value = null;

  public DataTransformHolder ()
  {
  }

  public DataTransformHolder (DataService.DataTransform initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DataService.DataTransformHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DataService.DataTransformHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DataService.DataTransformHelper.type ();
  }

}
