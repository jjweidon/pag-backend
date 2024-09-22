package com.punsaeng.pag.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardRequest request) {
        BoardResponse board = boardService.createBoard(request);
        log.info("Response POST create board: {}", board);
        return ResponseEntity.status(HttpStatus.CREATED).body(board);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardResponse> updateBoard(
            @PathVariable Long boardId,
            @RequestBody BoardRequest request) {
        BoardResponse updatedBoard = boardService.updateBoard(boardId, request);
        log.info("Response PUT update board: {}", updatedBoard);
        return ResponseEntity.ok(updatedBoard);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        log.info("Response DELETE board with id: {}", boardId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getBoardList() {
        List<BoardResponse> boards = boardService.getBoardList();
        log.info("Response GET board list: {}", boards);
        return ResponseEntity.ok(boards);
    }

    @PostMapping("/{boardId}/comments")
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable Long boardId,
            @RequestBody CommentRequest request) {
        CommentResponse comment = boardService.createComment(boardId, request);
        log.info("Response POST create comment: {}", comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @PutMapping("/{boardId}/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(
            @PathVariable Long boardId,
            @PathVariable Long commentId,
            @RequestBody CommentRequest request) {
        CommentResponse updatedComment = boardService.updateComment(boardId, commentId, request);
        log.info("Response PUT update comment: {}", updatedComment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{boardId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long boardId,
            @PathVariable Long commentId) {
        boardService.deleteComment(boardId, commentId);
        log.info("Response DELETE comment with id: {}", commentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{boardId}/comments")
    public ResponseEntity<List<CommentResponse>> getCommentList(@PathVariable Long boardId) {
        List<CommentResponse> comments = boardService.getCommentList(boardId);
        log.info("Response GET comment list for boardId: {}", boardId);
        return ResponseEntity.ok(comments);
    }
}
