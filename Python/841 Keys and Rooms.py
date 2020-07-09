class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        N = len(rooms)
        visited = [False]*N 
        def dfs(rooms,visited,start):
            if visited[start] :
                return
            visited[start] = True 
            for key in rooms[start]:
                if not visited[key]:
                    dfs(rooms,visited,key) 
        dfs(rooms,visited,0) 
        for room in visited:
            if room == False:
                return False 
        return True