package romanizat.esports.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import romanizat.esports.entity.*;
import romanizat.esports.service.*;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllGames")
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{gameId}")
    @ApiOperation(value = "", nickname = "getGameById")
    public ResponseEntity<Game> getGameById(@PathVariable Integer gameId) {
        return ResponseEntity.ok(gameService.findById(gameId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveGame")
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.save(game));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateGame")
    public ResponseEntity<Game> updateGame(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.update(game));
    }

    @DeleteMapping("/{gameId}")
    @ApiOperation(value = "", nickname = "deleteGameById")
    public void deleteGameById(@PathVariable Integer gameId) {
        gameService.deleteById(gameId);
    }

}

