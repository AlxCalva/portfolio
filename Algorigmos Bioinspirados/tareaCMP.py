def min_mon(n, monedas):
    dp = [[float('inf')] * (n + 1) for _ in range(len(monedas) + 1)]
    
    for i in range(len(monedas) + 1):
        dp[i][0] = 0

    for i in range(1, len(monedas) + 1):
        for j in range(n + 1):
            if monedas[i - 1] <= j:
                dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - monedas[i - 1]])
            else:
                dp[i][j] = dp[i - 1][j]

    for row in dp:
        print(row)
    
    return dp[len(monedas)][n]

monedas = [1, 3, 5]
N = 6
print("Mínimo número de monedas:", min_mon(N, monedas))
