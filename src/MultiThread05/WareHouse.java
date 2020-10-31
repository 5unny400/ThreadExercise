package MultiThread05;

class WareHouse {
    volatile int numOfThing;        //厂库中货物数量
    int MAXSIZE = 2;

    public WareHouse(int numOfThing){
        this.numOfThing = numOfThing;
    }

    public WareHouse(int numOfThing,int MAXSIZE){
        this.numOfThing = numOfThing;
        this.MAXSIZE = MAXSIZE;
    }

    synchronized public int getNumOfThing(){
        if(numOfThing >=0&&numOfThing<=MAXSIZE) {
            return numOfThing;
        }
        return -1;
    }

    //消费
    synchronized public int consume(){
        if(numOfThing<=MAXSIZE&&numOfThing>0) {
            numOfThing--;
            return 1;
        }
        return -1;
    }

    //生产
    synchronized public int produce(){
        if(numOfThing>=0&&numOfThing<MAXSIZE) {
            numOfThing++;
            return 1;
        }
        return -1;
    }

}
