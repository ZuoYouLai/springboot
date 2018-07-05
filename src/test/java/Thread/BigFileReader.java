package Thread;

import java.io.File;

public class BigFileReader {

    public  static class  Builder{
        private int threadSize=1;
        private String charset=null;
        private int bufferSize=1024*1024;
        private File file;
        private IHandle handle;

        public Builder(File file, IHandle handle) {
            this.file = file;
            if(!this.file.exists())
                throw new IllegalArgumentException("文件不存在!");
            this.handle = handle;
        }



    }


}
