package com.example.zzyzzy.semiprojectv1.service;

import com.example.zzyzzy.semiprojectv1.domain.*;

import java.util.List;

public interface BoardService {

    BoardListDTO readBoard(int cpg);

    BoardReplyDTO readOneBoardReply(int cpg);

    List<BoardDTO> findBoard(int cpg, String findtype, String findkey);

    int countfindBoard(String findtype, String findkey);

//    Board readOneBoard(int bno);

//    void readOneView(int bno);

    boolean newBoard(NewBoardDTO newboardDTO);

    boolean newReply(NewReplyDTO newreplyDTO);

//    List<Reply> readReply(int bno);

    boolean newComment(NewReplyDTO newreplyDTO);
}
