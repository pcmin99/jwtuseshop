async function replyMessage(messageId) {
    const reply = prompt("답변을 입력하세요:");
    if (reply) {
        await fetch(`/api/messages/${messageId}/reply`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ content: reply })
        });
        alert('답변이 전송되었습니다.');
        location.reload(); // 페이지 새로고침
    }
}