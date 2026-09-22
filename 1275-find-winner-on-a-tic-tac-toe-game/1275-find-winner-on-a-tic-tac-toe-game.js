/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {

    let board = Array.from({ length: 3 }, () => Array(3).fill(0));

    // Board fill karo
    for (let i = 0; i < moves.length; i++) {
        let [r, c] = moves[i];
        board[r][c] = i % 2 === 0 ? 1 : 2;
    }

    let win = [
        [0,1,2], [3,4,5], [6,7,8],
        [0,3,6], [1,4,7], [2,5,8],
        [0,4,8], [2,4,6]
    ];

    for (let p of win) {

        let a = board[Math.floor(p[0] / 3)][p[0] % 3];
        let b = board[Math.floor(p[1] / 3)][p[1] % 3];
        let c = board[Math.floor(p[2] / 3)][p[2] % 3];

        if (a !== 0 && a === b && b === c) {
            return a === 1 ? "A" : "B";
        }
    }

    return moves.length === 9 ? "Draw" : "Pending";
};