class Hopscotch {
    int hopscotch(int[][] board, int size) {
        int result = 0;
      	int[] index = new int[board.length];		// 이미 밟았던 열을 구별하기 위한 용도
      	int maxNum;		//가장 큰 수 저장용
      	int subNum;		//두번째 큰 수 저장용
        for(int i = 0; i<board.length; ++i){
          maxNum = 0;		//초기화
      		subNum = 0;		//초기화
        	for(int j = 0; j<board[i].length; ++j){            
          	
          	if(maxNum < board[i][j]){			// 현재 큰 수 maxNum 보다 새로운 수가 더 크다면
              subNum = maxNum;						// subNum에 현재 큰 수를 저장하고 (두번째 큰 수가 되기 때문에)
              maxNum = board[i][j];       // 새로운 수가 더 크기 때문에 maxNum에 새롭게 저장       	
              index[i] = j;								// 큰 수에 해당하는 열 값을 저장
            }else{												// 현재 큰 수가 가장 큰 수라면
              if(subNum < board[i][j]){			// 또한 두번째 큰 수 보다 새로운 수가 더 크다면 
                subNum = board[i][j]; 			// 새로운 두번째 큰 수가 되기 때문에 subNum에 새롭게 저장
              }              
            }
           
          }
         	//System.out.println("maxNum::: "+ maxNum);
          //System.out.println("subNum::: "+ subNum);
          //System.out.println(index[i]);
          if(i>0){														// 두번째 열부터
            if(index[i-1] != index[i]){				// 첫번째 행의 큰 수의 열 번호와 두번째 행의 큰 수의 열번호가 같지 않다면 
            	result += maxNum;								// 큰 수를 더함
            }else{														// 열번호가 같다면
            	result += subNum;								// 두번째 큰 수를 더함
            }
          }else{															// i가 0이면 처음이기 때문에
          	result = maxNum;									// 무조건 큰 수 더함
          }
        }      	
      
        return result;
    }

    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.hopscotch(test, 3));
    }

}