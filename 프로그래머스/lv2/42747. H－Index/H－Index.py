def solution(citations):
    citations.sort()
    return len([citations[i] for i in range(len(citations)) if citations[i]>=len(citations)-i])