                  /*  File:  hiddenA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hiddenA extends Template {

     static {templateClass = new hiddenA() ; }

     public void setup() {
          filePrefix = "hiddenA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 20*0.15 ;   
          ysize = 14*0.15 ;   
          xmin = -10  ;
          xmax = 10 ;
          ymin = -7 ;
          ymax = 7 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double r = 0.2 ;
          double OX = 5 ; double OY = 3 ;
          double IX = 2 ; double IY = 1 ;
          double SX = 1.0 ; double SY = 0.5 ;
          double x = 3 ; double y = OY*Math.sqrt(1-x*x/(OX*OX)) ;
          double ex = 6 ; double ey = 4.5 ;
          double vx = ex-x ; double vy = ey-y ;
       
          double th = 20 ; double thRad = th*Math.PI/180 ;
          double phiRad = Math.atan(vy/vx) ; double phi = phiRad*180/Math.PI ;
          double vxu = vx*Math.cos(thRad) -vy*Math.sin(thRad) ;
          double vyu = vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double vxl = vx*Math.cos(thRad) +vy*Math.sin(thRad) ;
          double vyl = -vx*Math.sin(thRad) +vy*Math.cos(thRad) ;
          double re = 1.0/(Math.sqrt(vx*vx+vy*vy)) ;
          double re2 = 0.75/(Math.sqrt(vx*vx+vy*vy)) ;


          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.6) ;
          fDisk(0,0, OX,OY, CLOSED+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(SX,SY, IX,IY, CLOSED+FILLED) ;

          fEnv("psFillGray", 0.85) ;
          fEnv("lineWidth", 0.5) ;
          fLine(ex-1.3*re2*vx,ey-1.3*re2*vy, x,y) ;
          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
          fLine(x, y, x-2.5*vx, y-2.5*vy ) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fDisk(x,y, r,r, CLOSED+FILLED) ;

          fLine(ex,ey, ex-re*vxu, ey-re*vyu) ;
          fLine(ex,ey, ex-re*vxl, ey-re*vyl) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, FILLED+WEDGE) ;
          fEllipticalArc(ex,ey, 0.75, 0.75, 180+phi-th, 180+phi+th, OPEN) ;

          double a = vx*vx/(OX*OX) + vy*vy/(OY*OY) ;
          double b = -2*ex*vx/(OX*OX) -2*ey*vy/(OY*OY) ;
          double c = ex*ex/(OX*OX) + ey*ey/(OY*OY) -1;
          double t1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a) ; 
          double x1 = ex-t1*vx ; double y1 = ey-t1*vy ;
          fEnv("psFillGray", 0.3) ;
          fDisk(x1,y1, r,r, CLOSED+FILLED) ;

          a = vx*vx/(IX*IX) + vy*vy/(IY*IY) ;
          b = -2*(ex-SX)*vx/(IX*IX) -2*(ey-SY)*vy/(IY*IY) ;
          c = (ex-SX)*(ex-SX)/(IX*IX) + (ey-SY)*(ey-SY)/(IY*IY) -1;
          t1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a) ; 
          x1 = ex-t1*vx ; y1 = ey-t1*vy ;
          fDisk(x1,y1, r,r, CLOSED+FILLED) ;

          t1 = (-b - Math.sqrt(b*b-4*a*c))/(2*a) ; 
          x1 = ex-t1*vx ; y1 = ey-t1*vy ;
          fDisk(x1,y1, r,r, CLOSED+FILLED) ;
     }
}
