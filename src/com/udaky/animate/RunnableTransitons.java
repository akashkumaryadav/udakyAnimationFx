package com.udaky.animate;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class RunnableTransitons {
        private Node _node;
        private Integer _time;

        public RunnableTransitons(Node node, Integer time){
            this._node = node;
            this._time = time;

        }
        public class FadeIn implements Runnable{
            private Integer _fadeFrom;
            private Integer _fadeTo;
            public FadeIn(Integer fadeFrom, Integer fadeTo){
                this._fadeFrom = fadeFrom;
                this._fadeTo = fadeTo;

            }
            @Override
            public void run(){
                FadeTransition fade = new FadeTransition();
                fade.setNode(_node);
                fade.setDuration(Duration.millis(_time));
                fade.setFromValue(_fadeFrom);
                fade.setToValue(_fadeTo);
                fade.play();
            }
        }


        //slide from left
        public class SlideFromLeft implements  Runnable{
            @Override
            public void run(){
                TranslateTransition transition = new TranslateTransition();
                transition.setDuration(Duration.millis(_time));
                transition.setFromY(0);
                transition.setFromX(-(_node.getLayoutX()+708));
                transition.setToX(0);
                transition.setToY(0);
                transition.setNode(_node);
                transition.play();

            }
        }
}
