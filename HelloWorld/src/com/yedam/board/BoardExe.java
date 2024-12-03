package com.yedam.board;

import java.util.Date;

public class BoardExe {
	private Board[] storage;

	public BoardExe() {
		storage = new Board[10];
		storage[0] = new Board(1, "자바", "열심히 합시다", "user01", new Date());
		storage[1] = new Board(2, "화요일", "열심히 합시다", "user02", new Date());
		storage[2] = new Board(3, "금요일", "열심히 합시다", "user01", new Date());
	}

	// 게시글 등록
	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}

	// 목록 정렬

	public Board[] boardList() {
		for (int j = 0; j < storage.length - 1; j++) {
			for (int i = 0; i < storage.length - 1; i++) {
				// 뒷자리가 null이면 그대로둠.
				if (storage[i + 1] == null) {
					continue;
				}
				
				Board temp = null;
				if (storage[i] == null || storage[i].getBoardNo() > storage[i + 1].getBoardNo()) {
					//위치변경 [i] <--> [i + 1]
					temp = storage[i];
					storage[i] = storage[i + 1];
					storage[i + 1] = temp;

				}
			} //end of 1st for.
		} // end of 2nd for.

		return storage;
	}

	// 글번호 가져오는 메소드
	// null이 아닌 카운트에 +1 한 값을 반환.
	// boardNo의 max값에 +1 한값을 반환.
	public int getNextNo() {
		int cnt = 0;

		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				int bno = storage[i].getBoardNo();
				if (cnt < bno) {
					cnt = bno;
				}
			}
		}
		return cnt + 1;
	}

	// 글삭제기능 => 매개값은 글번호, 반환값은 true/ false, deleteBoard()

	public boolean deleteBoard(int bno) {

		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == bno) {
				storage[i] = null;
				return true;

			}
		} // 종료
		return false;
	}

	// 글 수정기능 => 매개값은 글번호+내용+제목, 반환값은 true/false, updateBoard()
	public boolean updateBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {

			if (storage[i] != null && storage[i].getBoardNo() == board.getBoardNo()) {
				storage[i].setTitle(board.getTitle());
				storage[i].setContent(board.getContent());
				return true;

			}
		}
		return false;
	}

	// 삭제, 수정 권한있는지 체크 => 매개값은 글번호, 작성자, 반환값은 true/false
	// checkResponsibility()
	public boolean checkResponsibility(int bno, String writer) {

		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (storage[i].getBoardNo() == bno && storage[i].getWriter().equals(writer)) {
					// storage[i] = null;
					return true;
				}
			}
		} // 종료
		return false;

	}
}
