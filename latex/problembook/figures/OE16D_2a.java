                  /*  File:  OE16D_2a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE16D_2a extends Template {

     static {templateClass = new OE16D_2a() ; }

     public void setup() {
          filePrefix = "OE16D_2a" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.7*0.9 ;      // in inches
          ysize = 4.0*0.8 ;   // in inches. 
          xmin = -3.5 ;
          xmax = 1.2 ;
          ymin = -2.0 ;
          ymax = 2.0 ;
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
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.05, "tr", "$x$") ;
         fTeXlabel(-0.03, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("lineWidth", 1.0) ;

           fEnv("lineWidth", 1.0) ;
//             fTeXlabel(-0.35,0.2, "br", "${\\scriptstyle f=0}$") ;

           double C ;
           C = 0; fCurve(new FP(C), -3, 1, OPEN) ;
                  fCurve(new FM(C), -3, 1, OPEN) ;
                  fTeXlabel(-0.15,0.3, "rb", "${\\scriptstyle 0}$") ;
                  fTeXlabel(-0.15,-0.28, "rt", "${\\scriptstyle 0}$") ;

           C = 1; fCurve(new FP(C), -2.8785, -0.6535, OPEN) ;
                  fCurve(new FM(C), -2.8785, -0.6535, OPEN) ;
                  fCurve(new FP(C),  0.5323,  1.0, OPEN) ;
                  fCurve(new FM(C),  0.5323,  1.0, OPEN) ;
                  fCurve(new FV(C,-2.8785),  -0.05,  0.05, OPEN) ;
                  fCurve(new FV(C,-0.653),  -0.05,  0.05, OPEN) ;
                  fCurve(new FV(C, 0.532),  -0.05,  0.05, OPEN) ;
                  fTeXlabel(-0.15,0.75, "rb", "${\\scriptstyle -1}$") ;
                  fTeXlabel(-0.71,0.3, "lb", "${\\scriptstyle 1}$") ;
                  fTeXlabel( 0.53,0.3, "rb", "${\\scriptstyle 1}$") ;

           C = -1; fCurve(new FP(C), -3.103, 1.0, OPEN) ;
                   fCurve(new FM(C), -3.103, 1.0, OPEN) ;
                   fCurve(new FV(C,-3.104),  -0.04,  0.04, OPEN) ;
  
           C = 2; fCurve(new FP(C), -2.731, -1.005, OPEN) ;
                  fCurve(new FM(C), -2.731, -1.005, OPEN) ;
                  fCurve(new FP(C),  0.733,  1.0, OPEN) ;
                  fCurve(new FM(C),  0.733,  1.0, OPEN) ;
                  fCurve(new FV(C,-2.732),  -0.05,  0.05, OPEN) ;
                  fCurve(new FV(C,-1.0  ),  -0.07,  0.07, OPEN) ;
                  fCurve(new FV(C, 0.732),  -0.07,  0.07, OPEN) ;
                  fTeXlabel(-1.05,0.3, "lb", "${\\scriptstyle 2}$") ;
                  fTeXlabel( 0.73,0.3, "rb", "${\\scriptstyle 2}$") ;

           C = -2; fCurve(new FP(C), -3.195, 1.0, OPEN) ;
                   fCurve(new FM(C), -3.195, 1.0, OPEN) ;
                   fCurve(new FV(C,-3.196),  -0.05,  0.05, OPEN) ;
                   fTeXlabel(-0.15, 1.0, "rb", "${\\scriptstyle -2}$") ;


           C = 3; fCurve(new FP(C), -2.531, -1.348, OPEN) ;
                  fCurve(new FM(C), -2.531, -1.348, OPEN) ;
                  fCurve(new FP(C),  0.88,  1.0, OPEN) ;
                  fCurve(new FM(C),  0.88,  1.0, OPEN) ;
                  fCurve(new FV(C,-2.532),  -0.05,  0.05, OPEN) ;
                  fCurve(new FV(C,-1.347),  -0.07,  0.07, OPEN) ;
                  fCurve(new FV(C, 0.879),  -0.07,  0.07, OPEN) ;
                  fTeXlabel(-1.43,0.3, "lb", "${\\scriptstyle 3}$") ;
                  fTeXlabel( 0.92,0.3, "lb", "${\\scriptstyle 3}$") ;

           C = -3; fCurve(new FP(C), -3.278, 1.0, OPEN) ;
                   fCurve(new FM(C), -3.278, 1.0, OPEN) ;
                   fCurve(new FV(C,-3.279),  -0.05,  0.05, OPEN) ;
                   fTeXlabel(-0.15, 1.22, "rb", "${\\scriptstyle -3}$") ;


         C = 3.8; fCurve(new FP(C), -2.2481, -1.730, OPEN) ;
                  fCurve(new FM(C), -2.2481, -1.730, OPEN) ;
                  fCurve(new FV(C,-2.248),  -0.05,  0.05, OPEN) ;
                  fCurve(new FV(C,-1.729),  -0.07,  0.07, OPEN) ;
                  fTeXlabel(-1.8,0.18, "lb", "${\\scriptstyle 4}$") ;

           C = -4; fCurve(new FP(C), -3.354, 1.0, OPEN) ;
                   fCurve(new FM(C), -3.354, 1.0, OPEN) ;
                   fCurve(new FV(C,-3.355),  -0.07,  0.07, OPEN) ;
                   fTeXlabel(-0.15, 1.4, "rb", "${\\scriptstyle -4}$") ;

         double r = 0.03 ;
         fEnv("psFillColor", Blue) ;
         fDisk(-2.732,0,r,r*aspect, FILLED) ;
                   fTeXlabel(-2.72, 0.05, "lb", "$R$") ;
         fDisk(-2,0,r,r*aspect, FILLED) ;
                   fTeXlabel(-1.97, 0.02, "lb", "$T$") ;
         fDisk( 0,0,r,r*aspect, FILLED) ;
                   fTeXlabel(0.15, 0.02, "lb", "$U$") ;
         fDisk( 0,0.71,r,r*aspect, FILLED) ;
                   fTeXlabel(0, 0.69, "lt", "$P$") ;
         fDisk(-2.88,0.9,r,r*aspect, FILLED) ;
                   fTeXlabel(-2.9, 0.9, "rb", "$Q$") ;
         fDisk(-1,-0.58,r,r*aspect, FILLED) ;
                   fTeXlabel(-0.97, -0.7, "lb", "$S$") ;


          
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
          out[1] =   Math.sqrt( (C-20)/(t-2) -t*t -5*t -10 ) ;
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
          out[1] =   -Math.sqrt( (C-20)/(t-2) -t*t -5*t -10 ) ;
          return out ;
   }
}



class FV implements S2V {

   double C = 10 ;
   double X1 = 0 ;

   public FV(double C, double X1) {
        this.C = C ;
        this.X1 = X1 ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          out[0] = X1+(C+2*t*t-X1*t*t-3*X1*X1-X1*X1*X1)/(3*X1*X1+6*X1+t*t)  ;
          out[1] = t ;
          return out ;
   }
}

