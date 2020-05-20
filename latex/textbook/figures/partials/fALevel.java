                  /*  File:  fALevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fALevel extends Template {

     static {templateClass = new fALevel() ; }

     public void setup() {
          filePrefix = "fALevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;      // in inches
          ysize = 3.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 3 ;
          ymin = -0.3 ;
          ymax = 6 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
         double r = 0.03 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("lineWidth", 1.0) ;
//         fLine(xmin, ymin, xmax, ymax) ;
//         fLine(xmin, -ymin, xmax, -ymax) ;

           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(1.6,0.5, 1.05,0.95) ;
                  fTeXlabel(1.6,0.5, "cl", "${\\scriptstyle (1,1),\\ f(1,1)=1}$") ;
                  fArrow(1.2,5, 1.97,4.03) ;
                  fTeXlabel(1.2,5, "cr", "${\\scriptstyle f(2,4)=0,\\ (2,4)}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;



//             fTeXlabel(-0.35,0.2, "br", "${\\scriptstyle f=0}$") ;

           double C ;
           C = 0; fCurve(new FP(C), -2, 0.5, OPEN) ;
                  fCurve(new FM(C), -2, 0.5, OPEN) ;
                  fTeXlabel(0.4,-0.2, "cr", "${\\scriptstyle f=0}$") ;

           C = 0.25; fCurve(new FP(C), -2, 0.5603, OPEN) ;
                    fCurve(new FM(C), -2, 0.5603, OPEN) ;
                    fCurve(new FP(C), 1.67365, 2.266027, OPEN) ;
                    fCurve(new FM(C), 1.67365, 2.266027, OPEN) ;
           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(2.48,3, 1.77,3.5) ;
                  fTeXlabel(2.5,3, "cl", "${\\scriptstyle f=0.25}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;


           C = 0.5; fCurve(new FP(C), -2, 0.63397, OPEN) ;
                    fCurve(new FM(C), -2, 0.63397, OPEN) ;
                    fCurve(new FP(C), 1.5, 2.36602, OPEN) ;
                    fCurve(new FM(C), 1.5, 2.36602, OPEN) ;
           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(2.48,2.5, 1.55,2.7) ;
                  fTeXlabel(2.5,2.5, "cl", "${\\scriptstyle f=0.5}$") ;
                  fTeXlabel(0.45,0.3, "cl", "${\\scriptstyle f=0.5}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;




           C = 1; fCurve(new FP(C), -2, 2.5, OPEN) ;
                  fCurve(new FM(C), -2, 2.5, OPEN) ;
           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(2.48,2, 1.53,1.8) ;
                  fArrow(2.48,2, 1.22,2.0) ;
                  fTeXlabel(2.5,2, "cl", "${\\scriptstyle f=1}$") ;
                  fArrow(1.33,-0.2, 0.96,0.7) ;
                  fArrow(1.33,-0.2, 0.72,0.7) ;
                  fTeXlabel(1.35,-0.2, "cl", "${\\scriptstyle f=1}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;



//           C = -1; fCurve(new FP(C), -2, 0.322349, OPEN) ;
//                  fCurve(new FM(C), -2, 0.322349, OPEN) ;

  
           C = 2; fCurve(new FP(C), -2, 2.6776, OPEN) ;
                  fCurve(new FM(C), -2, 2.6776, OPEN) ;
           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("psFillColor", Black) ;
                  fArrow(2.48,1.5, 1.6,1.5) ;
                  fTeXlabel(2.5,1.5, "cl", "${\\scriptstyle f=2}$") ;
                  fArrow(0.52,2.0, 0.92,1.8) ;
                  fTeXlabel(0.5,2.0, "cr", "${\\scriptstyle f=2}$") ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;



           C = 3; fCurve(new FP(C), -2, 2.8, OPEN) ;
                  fCurve(new FM(C), -2, 2.8, OPEN) ;
                  fTeXlabel(1.6,1, "cl", "${\\scriptstyle f=3}$") ;
                  fTeXlabel(0.5,1.4, "cr", "${\\scriptstyle f=3}$") ;

         fEnv("psFillColor", Blue) ;
         fDisk(1,1,r,r*aspect, FILLED) ;
         fDisk(2,4,r,r*aspect, FILLED) ;

          
     }
}

class FP implements S2V {

   double C = 10 ;

   public FP(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t  ;
          out[1] =   0.5*( -(4-6*t) + Math.sqrt( (4-6*t)*(4-6*t) -4*(2*t*t*t-C)  ) ) ;
          return out ;
   }
}


class FM implements S2V {

   double C = 10 ;

   public FM(double C) {
        this.C = C ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = t  ;
          out[1] =   0.5*( -(4-6*t) - Math.sqrt( (4-6*t)*(4-6*t) -4*(2*t*t*t-C)  ) ) ;
          return out ;
   }
}

